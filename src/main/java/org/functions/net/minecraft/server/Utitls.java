package org.functions.net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.functions.net.minecraft.server.ServerVersion.Version;

public class Utitls {
	public static class JavaAccessibilities {
		public static boolean isAccessible(Field field, Object target) {
			if (getCurrentVersion() >= 9 && target != null) {
				try {
					return (Boolean)field.getClass().getDeclaredMethod("canAccess", Object.class).invoke(field, target);
				} catch (NoSuchMethodException var3) {
				} catch (Exception var4) {
					var4.printStackTrace();
				}
			}

			return field.isAccessible();
		}

		public static boolean isAccessible(Method method, Object target) {
			if (getCurrentVersion() >= 9 && target != null) {
				try {
					return (Boolean)method.getClass().getDeclaredMethod("canAccess", Object.class).invoke(method, target);
				} catch (NoSuchMethodException var3) {
				} catch (Exception var4) {
					var4.printStackTrace();
				}
			}

			return method.isAccessible();
		}

		public static int getCurrentVersion() {
			String currentVersion = System.getProperty("java.version");
			if (currentVersion.contains("_")) {
				currentVersion = currentVersion.split("_")[0];
			}

			currentVersion = currentVersion.replaceAll("[^\\d]|_", "");

			for(int i = 8; i <= 18; ++i) {
				if (currentVersion.contains(Integer.toString(i))) {
					return i;
				}
			}

			return 0;
		}
	}
	public static class Classes {
		public static Object getPlayerConstructor(Player player, Object profile) {
			Class<?> server = getMinecraftServer();
			Object serverIns = getServer(server);

			try {
				Class<?> manager = Utitls.getNMSClass("PlayerInteractManager");
				Object managerIns = null;
				Object world = null;
				if (Version.isCurrentEqualOrHigher(Version.v1_14_R1)) {
					world = Utitls.getHandle(player.getWorld());
					managerIns = manager.getConstructor(world.getClass()).newInstance(world);
				} else if (!Version.isCurrentEqual(Version.v1_13_R1) && !Version.isCurrentEqual(Version.v1_13_R2)) {
					world = server.getDeclaredMethod("getWorldServer", Integer.TYPE).invoke(serverIns, 0);
				} else {
					world = Utitls.getHandle(player.getWorld());
				}

				if (managerIns == null) {
					managerIns = manager.getConstructors()[0].newInstance(world);
				}

				return Utitls.getHandle(player).getClass().getConstructor(server, world.getClass(), profile.getClass(), manager).newInstance(serverIns, world, profile, managerIns);
			} catch (Exception var7) {
				var7.printStackTrace();
				return null;
			}
		}

		public static Class<?> getMinecraftServer() {
			try {
				return Utitls.getNMSClass("MinecraftServer");
			} catch (ClassNotFoundException var3) {
				try {
					return Utitls.getNMSClass("DedicatedServer");
				} catch (ClassNotFoundException var2) {
					return null;
				}
			}
		}

		public static Object getServer(Class<?> server) {
			try {
				return server.getMethod("getServer").invoke(Utitls.getCraftClass("CraftServer").cast(Bukkit.getServer()));
			} catch (ReflectiveOperationException var4) {
				try {
					return server.getMethod("getServer").invoke(server);
				} catch (ReflectiveOperationException var3) {
					return null;
				}
			}
		}

		public static Class<?> getEnumPlayerInfoAction(Class<?> packetPlayOutPlayerInfo) {
			try {
				if (Version.isCurrentEqual(Version.v1_8_R1)) {
					return Utitls.getNMSClass("EnumPlayerInfoAction");
				} else {
					return Version.isCurrentEqualOrHigher(Version.v1_11_R1) ? packetPlayOutPlayerInfo.getDeclaredClasses()[1] : packetPlayOutPlayerInfo.getDeclaredClasses()[2];
				}
			} catch (ReflectiveOperationException var2) {
				var2.printStackTrace();
				return null;
			}
		}
	}
	private static final Gson GSON = (new GsonBuilder()).create();
	private static final List<JsonObject> JSONLIST = new CopyOnWriteArrayList();

	private Utitls() {
	}

	public static Object getHandle(Object obj) throws Exception {
		return invokeMethod(obj, "getHandle");
	}

	public static synchronized Object getAsIChatBaseComponent(String text) throws Exception {
		Class<?> iChatBaseComponent = getNMSClass("IChatBaseComponent");
		if (!Version.isCurrentEqualOrHigher(Version.v1_16_R1)) {
			if (Version.isCurrentLower(Version.v1_8_R2)) {
				Class<?> chatSerializer = getNMSClass("ChatSerializer");
				return iChatBaseComponent.cast(chatSerializer.getMethod("a", String.class).invoke(chatSerializer, "{\"text\":\"" + text + "\"}"));
			} else {
				Method m = iChatBaseComponent.getDeclaredClasses()[0].getMethod("a", String.class);
				return m.invoke(iChatBaseComponent, "{\"text\":\"" + text + "\"}");
			}
		} else {
			JSONLIST.clear();
			JsonObject obj = new JsonObject();
			StringBuilder builder = new StringBuilder();
			String res = text;
			String font = "";
			String colorName = "";
			char charBefore = ' ';

			for(int i = 0; i < res.length() && i < res.length(); ++i) {
				if (charBefore == '&') {
					charBefore = ' ';
				} else {
					char charAt = res.charAt(i);
					if (charAt == '{') {
						int closeIndex = -1;
						if (res.regionMatches(true, i, "{font=", 0, 6) && (closeIndex = res.indexOf(125, i + 6)) >= 0) {
							font = NamespacedKey.minecraft(res.substring(i + 6, closeIndex)).toString();
						} else if (res.regionMatches(true, i, "{/font", 0, 6) && (closeIndex = res.indexOf(125, i + 6)) >= 0) {
							font = NamespacedKey.minecraft("default").toString();
						}

						if (closeIndex >= 0) {
							if (builder.length() > 0) {
								obj.addProperty("text", builder.toString());
								JSONLIST.add(obj);
								builder = new StringBuilder();
							}

							obj = new JsonObject();
							obj.addProperty("font", font);
							i += closeIndex - i;
						}
					} else if (charAt == '#') {
						colorName = res.substring(i, i + 7);
						if (builder.length() > 0) {
							obj.addProperty("text", builder.toString());
							JSONLIST.add(obj);
							builder = new StringBuilder();
						}

						obj = new JsonObject();
						obj.addProperty("color", colorName);
						i += 6;
					} else if (charAt == '&') {
						charBefore = charAt;
						char colorCode = res.charAt(i + 1);
						if (Character.isDigit(colorCode) || colorCode >= 'a' && colorCode <= 'f' || colorCode == 'k' || colorCode == 'l' || colorCode == 'm' || colorCode == 'n' || colorCode == 'o' || colorCode == 'r') {
							obj.addProperty("text", builder.toString());
							JSONLIST.add(obj);
							obj = new JsonObject();
							builder = new StringBuilder();
							if (!colorName.isEmpty()) {
								obj.addProperty("color", colorName);
							}

							if (!font.isEmpty()) {
								obj.addProperty("font", font);
							}

							switch(colorCode) {
								case 'k':
									obj.addProperty("obfuscated", true);
									break;
								case 'l':
									obj.addProperty("bold", true);
									break;
								case 'm':
									obj.addProperty("strikethrough", true);
									break;
								case 'n':
									obj.addProperty("underlined", true);
									break;
								case 'o':
									obj.addProperty("italic", true);
									break;
								case 'p':
								case 'q':
								default:
									colorName = ChatColor.getByChar(colorCode).name().toLowerCase();
									obj.addProperty("color", colorName);
									break;
								case 'r':
									colorName = "white";
									obj.addProperty("color", colorName);
							}
						}
					} else {
						builder.append(charAt);
					}
				}
			}

			obj.addProperty("text", builder.toString());
			JSONLIST.add(obj);
			Method m = iChatBaseComponent.getDeclaredClasses()[0].getMethod("a", String.class);
			return m.invoke(iChatBaseComponent, GSON.toJson(JSONLIST));
		}
	}

	public static Object invokeMethod(Object obj, String name) throws Exception {
		return invokeMethod(obj, name, true, false);
	}

	public static Object invokeMethod(Object obj, String name, boolean superClass) throws Exception {
		return invokeMethod(obj, name, true, superClass);
	}

	public static Object invokeMethod(Object obj, String name, boolean declared, boolean superClass) throws Exception {
		Class<?> c = superClass ? obj.getClass().getSuperclass() : obj.getClass();
		Method met = declared ? c.getDeclaredMethod(name) : c.getMethod(name);
		if (!Utitls.JavaAccessibilities.isAccessible(met, obj)) {
			met.setAccessible(true);
		}

		return met.invoke(obj);
	}

	public static Class<?> getNMSClass(String name) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + getPackageVersion() + "." + name);
	}

	public static Class<?> getCraftClass(String className) throws ClassNotFoundException {
		return Class.forName("org.bukkit.craftbukkit." + getPackageVersion() + "." + className);
	}

	public static Field getField(Object clazz, String name) throws Exception {
		return getField(clazz, name, true);
	}

	public static Field getField(Object clazz, String name, boolean declared) throws Exception {
		return getField(clazz.getClass(), name, declared);
	}

	public static Field getField(Class<?> clazz, String name) throws Exception {
		return getField(clazz, name, true);
	}

	public static Field getField(Class<?> clazz, String name, boolean declared) throws Exception {
		Field field = declared ? clazz.getDeclaredField(name) : clazz.getField(name);
		if (!Utitls.JavaAccessibilities.isAccessible(field, (Object)null)) {
			field.setAccessible(true);
		}

		return field;
	}

	public static void modifyFinalField(Field field, Object target, Object newValue) throws Exception {
		Field modifiersField = null;

		try {
			modifiersField = Field.class.getDeclaredField("modifiers");
		} catch (NoSuchFieldException var12) {
			if (Utitls.JavaAccessibilities.getCurrentVersion() < 12) {
				return;
			}

			Method meth = Class.class.getDeclaredMethod("getDeclaredFields0", Boolean.TYPE);
			boolean accessibleBeforeSet = Utitls.JavaAccessibilities.isAccessible(meth, (Object)null);
			meth.setAccessible(true);
			Field[] fields = (Field[])meth.invoke(Field.class, false);
			Field[] var8 = fields;
			int var9 = fields.length;

			for(int var10 = 0; var10 < var9; ++var10) {
				Field f = var8[var10];
				if ("modifiers".equals(f.getName())) {
					modifiersField = f;
					break;
				}
			}

			meth.setAccessible(accessibleBeforeSet);
		}

		if (modifiersField != null) {
			field.setAccessible(true);
			if (Utitls.JavaAccessibilities.getCurrentVersion() < 13) {
				modifiersField.setAccessible(true);
				modifiersField.setInt(field, field.getModifiers() & -17);
				field.set(target, newValue);
			} else {
				boolean accessibleBeforeSet = Utitls.JavaAccessibilities.isAccessible(modifiersField, (Object)null);
				modifiersField.setAccessible(true);
				modifiersField.setInt(field, field.getModifiers() & -17);
				field.set(target, newValue);
				modifiersField.setAccessible(accessibleBeforeSet);
			}

		}
	}

	public static Object getFieldObject(Object object, Field field) throws Exception {
		return field.get(object);
	}

	public static void setField(Object object, String fieldName, Object fieldValue) throws Exception {
		getField(object, fieldName).set(object, fieldValue);
	}

	public static void sendPacket(Player player, Object packet) {
		try {
			Object playerHandle = getHandle(player);
			Object playerConnection = getFieldObject(playerHandle, getField(playerHandle, "playerConnection"));
			playerConnection.getClass().getDeclaredMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
		} catch (Exception var4) {
		}

	}

	public static String getPackageVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}
}

package org.functions.Utlis;

import java.util.Iterator;
import java.util.List;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.functions.API.PlayerNMS;

public class Mobs {
    private PlayerNMS nms = new PlayerNMS();
    private World w;

    public Mobs(World World) {
        this.w = World;
    }

    public List<Entity> getEntity() {
        return this.w.getEntities();
    }

    public int getItemCount() {
        int i = 0;
        Iterator var2 = this.getEntity().iterator();

        while(var2.hasNext()) {
            Entity e = (Entity)var2.next();
            if (e.getType() == EntityType.DROPPED_ITEM) {
                ++i;
            }
        }

        return i;
    }

    public int ClearItemInt() {
        int i = 0;
        Iterator var2 = this.getEntity().iterator();

        while(var2.hasNext()) {
            Entity e = (Entity)var2.next();
            if (e.getType().equals(EntityType.DROPPED_ITEM)) {
                e.remove();
                ++i;
            }
        }

        return i;
    }

    public void ClearItem() {
        Iterator var1 = this.getEntity().iterator();

        while(var1.hasNext()) {
            Entity e = (Entity)var1.next();
            if (e.getType().equals(EntityType.DROPPED_ITEM)) {
                e.remove();
            }
        }

    }
}

package xyz.blobsu.scoreData;

import java.util.EnumSet;
import java.util.Set;

public enum Mods {
    NM(0),
    NF(1 << 0),
    EZ(1 << 1),
    TD(1 << 2),  // old: 'NOVIDEO'
    HD(1 << 3),
    HR(1 << 4),
    SD(1 << 5),
    DT(1 << 6),
    RX(1 << 7),
    HT(1 << 8),
    NC(1 << 9),
    FL(1 << 10),
    AUTO(1 << 11),
    SO(1 << 12),
    AP(1 << 13),
    PF(1 << 14),
    K4(1 << 15),
    K5(1 << 16),
    K6(1 << 17),
    K7(1 << 18),
    K8(1 << 19),
    FI(1 << 20),
    RAND(1 << 21),
    CN(1 << 22),
    TG(1 << 23),
    K9(1 << 24),
    KOP(1 << 25),
    K1(1 << 26),
    K3(1 << 27),
    K2(1 << 28),
    SV2(1 << 29),
    MR(1 << 30);

    private final int value;

    Mods(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Set<Mods> fromInt(int bitmask) {
        Set<Mods> mods = EnumSet.noneOf(Mods.class);
        for (Mods mod : Mods.values()) {
            if ((bitmask & mod.value) != 0) {
                mods.add(mod);
            }
        }
        return mods;
    }

    public static int toInt(Set<Mods> mods) {
        int bitmask = 0;
        for (Mods mod : mods) {
            bitmask |= mod.value;
        }
        return bitmask;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public int modName() {
        return this.toString().charAt(0) + toString().charAt(1);
    }


}


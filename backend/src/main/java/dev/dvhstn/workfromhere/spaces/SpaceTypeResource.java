package dev.dvhstn.workfromhere.spaces;

import lombok.Getter;

@Getter
public enum SpaceTypeResource {
    CAFE(1, "Cafe"),
    HOT_DESK(2, "Hot Desk");

    private final int id;
    private final String name;

    SpaceTypeResource(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

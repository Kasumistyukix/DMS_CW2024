package com.example.demo.actor;

/**
 * {@code RemovalReason} is an enumeration that defines the possible reasons for the removal of an actor in the game.
 * This can be used to categorize why an actor, such as a fighter plane, has been destroyed or removed from the game world.
 */
public enum RemovalReason {

    /**
     * Indicates that the actor was removed due to being killed in the game, such as after taking enough damage.
     */
    KILLED,

    /**
     * Indicates that the actor was removed because it went out of the bounds of the game area, such as flying off-screen.
     */
    OUT_OF_BOUNDS,

    /**
     * A general reason for removal that can be used for any other cases not covered by the above reasons.
     */
    OTHER
}


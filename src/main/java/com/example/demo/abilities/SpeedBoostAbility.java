package com.example.demo.abilities;

public class spd implements Ability {
    private static final double SPEED_MULTIPLIER = 4.0;
    private static final long DURATION = 10_000; // 10 seconds

    private long startTime;
    private boolean active;

    @Override
    public void activate(FighterPlane plane) {
        if (!active) {
            active = true;
            startTime = System.currentTimeMillis();
            plane.setSpeed(plane.getSpeed() * SPEED_MULTIPLIER); // Apply speed boost
        }
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void update(long currentTime) {
        if (active && currentTime - startTime >= DURATION) {
            active = false;
            // Reset speed after ability ends
            FighterPlane plane = (FighterPlane) plane; // Example to reset speed
            plane.setSpeed(plane.getSpeed() / SPEED_MULTIPLIER);
        }
    }
}

package com.example.demo.projectile;

/**
 * The {@code EnemyProjectile} class represents projectiles fired by a enemy enemy.
 * It extends the {@code Projectile} class and provides unique behavior for enemy projectiles,
 * including its size, velocity, and starting position.
 */
public class EnemyProjectile extends Projectile {
    /**
     * The image name for the enemy's projectile.
     * This string specifies the file name of the enemy projectile image.
     */
    private static final String IMAGE_NAME = "enemyFire.png";

    /**
     * The height of the enemy's projectile image.
     * Defines the vertical size of the enemy's projectile image in pixels.
     */
    private static final int IMAGE_HEIGHT = 50;

    /**
     * The horizontal velocity of the enemy's projectile.
     * Determines how fast the projectile moves horizontally (to the left).
     */
    private static final int HORIZONTAL_VELOCITY = -10;


    /**
     * Constructs a new {@code EnemyProjectile} instance with specified initial position.
     *
     * @param initialXPos the initial x-coordinate of the projectile.
     * @param initialYPos the initial y-coordinate of the projectile.
     */
    public EnemyProjectile(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
    }

    /**
     * Updates the position of the projectile by moving it horizontally to the left.
     * The movement is determined by the {@code HORIZONTAL_VELOCITY}.
     */
    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY);
    }

    /**
     * Updates the actor's state. For {@code EnemyProjectile}, this simply updates its position.
     */
    @Override
    public void updateActor() {
        updatePosition();
    }
}

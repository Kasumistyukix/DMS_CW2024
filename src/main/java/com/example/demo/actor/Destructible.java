package com.example.demo.actor;

/**
 * The {@code Destructible} interface defines the behavior of objects
 * that can take damage and be destroyed.
 */
public interface Destructible {

	/**
	 * Applies damage to the object. The implementation should define
	 * how the object responds to taking damage.
	 */
	void takeDamage();

	/**
	 * Destroys the object. The implementation should define
	 * the behavior for when the object is destroyed.
	 */
	void destroy();
}


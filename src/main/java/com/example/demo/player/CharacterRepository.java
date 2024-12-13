package com.example.demo.player;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.abilities.InvincibilityAbility;
import com.example.demo.abilities.SpeedBoostAbility;

/**
 * Repository class to manage and retrieve character data.
 * This class serves as a storage for character information, allowing easy access to pre-defined characters.
 */
public class CharacterRepository {

    /**
     * A static map that holds the character names as keys and their associated CharacterData as values.
     */
    private static final Map<String, CharacterData> characters = new HashMap<>();

    static {
        characters.put("Laughing Fox", new CharacterData("Laughing Fox", 10, 1.5, new InvincibilityAbility()));
        characters.put("Flame Ogre", new CharacterData("Flame Ogre", 18, 0.8, new SpeedBoostAbility()));
    }

    /**
     * Retrieves the character data associated with the given character name.
     *
     * @param name The name of the character to retrieve.
     * @return The CharacterData associated with the given name, or null if the character is not found.
     */
    public static CharacterData getCharacter(String name) {
        return characters.get(name);
    }

    /**
     * Retrieves all the characters stored in the repository.
     *
     * @return A map of all characters, where the key is the character name and the value is the associated CharacterData.
     */
    public static Map<String, CharacterData> getAllCharacters() {
        return characters;
    }
}

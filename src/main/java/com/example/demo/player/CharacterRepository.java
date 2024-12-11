package com.example.demo.player;

import java.util.HashMap;
import java.util.Map;

public class CharacterRoster {
    private static final Map<String, CharacterData> characters = new HashMap<>();

    static {
        characters.put("Warrior", new CharacterData("Warrior", 100, 1.0, new SpeedBoostAbility()));
        characters.put("Mage", new CharacterData("Mage", 80, 1.2, new InvincibilityAbility()));
        characters.put("Rogue", new CharacterData("Rogue", 70, 1.5, new SpeedBoostAbility()));
    }

    public static CharacterData getCharacter(String name) {
        return characters.get(name);
    }

    public static Map<String, CharacterData> getAllCharacters() {
        return characters;
    }

}

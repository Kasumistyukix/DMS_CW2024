## Github
https://github.com/Kasumistyukix/DMS_CW2024.git

## Compilation Instructions
 Use IntelLiJ Idea , make sure Maven is installed, to do so, 
 1. Go to File > Settings > Plugins
 2. Search Maven, and install.
 
 Run "Main" to start the game

## Implemented and Working Properly
1. **Cropped**: `enemyplane.png`
    - Plane found to be too large
2. **Fixed**: Level transition from `LevelOne` to `LevelTwo`
    - Timeline wasnt stopped before level transition
3. **Fixed**: Shield not displaying properly
    - Shield not displaying causing game to crash
4. **Fixed**: `GameOverImage` covering the whole screen
    - Implementation changed similar to WinImage
5. **Refactored**: `GameOverImage`
    - GameOverImage functionality grouped with WinImage
    - A common Win/Lost Image class was not made due to introducing unnecessary complexity 
6. **Added**: Main Menu, Character Selection Menu, and How To Play screens
    - Added Main Menu so that Game does not start instantly upon running main as well as for player navigation
    - Added How To play scene to display controls
    - Added Character Selection scene for player to select their Pilot with differing stats and abilities
7. **Fixed**: Resizing of game window due to `scene.getWidth()` and `scene.getHeight()`; now uses `root` dimensions
    - Implementation of scenes caused windows to enlarge everytime during scene transition, especially visible with the use of a sceneManager
    - This is due to the implementation before counting in the game window border and label as part of the width and height.
8. **Avoided**: Injecting `GameController` through scene transitions; instead, inject `Stage` object
   - Early Implementation appears to unnecessarily pass around 'GameController' during transition between menu scenes as it is initialised with the stage object
   - the Stage is instead passed from controller to controller instead of the GameController object
9. **Fixed**: Bug where kill count increased when `enemyPlane` traveled OutOfBounds (`PenetratedDefense`)
   - Gameplay implies only collisions against `userPlane` and `userProjectiles` count as kills.
   - Kill counter simply increments when the number of current active enemy planes that are not destroyed on the field is lesser than the current all enemy planes.
   - Game has no distinction between an enemy removed by outOfBounds and player caused kills
10. **Implemented**: `Level Three`
    - Level 3 features both a boss and normal enemy planes
    - Player must defeat the boss to win
11. **Fixed**: Shooting when the game is over
    - Checks if game is over before performing any key input handling
12. **Tweaked**: Boss stats
    - Lower health , shield frames and shield probability as Boss fight takes too long and shield lasts too long
13. **Refactored**: Package structure
    - Classes are categorised by functionality for organisation
14. **Implemented**: Stage Configurer utility in controllers (not used yet)
    - Extra utility if scenes need to be configured in sie later on
15. **Tweaked**: Boss stats
    - Lower health , shield frames and shield probability as Boss fight takes too long and shield lasts too long
16. **Refactored**: Package structure
    - Classes are categorised by functionality for organisation
17. **Implemented**: Stage Configurer utility in controllers (not used yet)
    - Extra utility if scenes need to be configured later on
18. **Implemented**: Character System backend
    - Character system where characters are defined and be selected from the CharacterSelectScene
    - Integrated system of multiple characters into the game via loading predefined character stats into UserPlane
    - Theoretically can supports addition of adding new characters by updating the CharacterRepository and CharacterSelect Screen accordingly
19. **Implemented**: Ability System
    - Enable characters to have a unique ability assigned to manipulate the properties of UserPlane
    - Implemented 2 different abilities to enhance uniqueness of characterSelect System  making use of modularity provided by Implementation allowed 2 different types of cooldown tracking
    - **Frame Based cooldown**
      - Utilises logic similar to the Boss Shield whereby a frame counter is implemented and incremented everytime the game state is updated
      - Hard to predict duration of ability based on frames entered. IE, a 100 frame ability may only last for 6-7 real seconds
    - **Real Time Based cooldown**
      - Utilises system time to determine ability duration and cooldown
      - This implementation is more predictable in terms of cooldown and duration because it updates independently of the game state.
    - **Implemented Abilities**
      - Invincibility ( utilised by Laughing Fox character)
        - Real Time Based cooldown
      - SpeedBoost  ( utilised by Flame Ogre character)
        - Frame Based cooldown


## Implemented and not Working Properly

### 1. Java Junit  Test 
- **Description**: shieldTest, levelParentTest and  mainTest don't work 
- **Current Issue**: The test does not work properly

### 2. Enemy Flagging System
- **Description**: A system was added to flag enemies as destroyed when:
    - They go out of bounds.
    - They are killed by a projectile.
    - "Other" for special circumstances
- **Current Issue**: Enemies are not flagged correctly, and the game operates as if this system does not exist.

### 3. UserPlane Left and Right Movement
- **Description**: The `UserPlane` was intended to have left and right movement controls.
- **Current Issue**: The `UserPlane` does not move left or right, despite the movement logic being implemented.

### 4. Sound System
- **Description**: A sound effect system was added to play audio effects using `javafx.media`.
- **Current Issue**: The `javafx.media` symbol is not found, preventing the sound system from working.

## Features Not Implemented
1. Implement java.beans to replace deprecated Observable
    - Unclear whether replacement will be in scope of assignment objective
2. Endless Game mode and by extension a Level Factory class
    - Inability to figure out how to refactor Level classes actively discouraged the implementation of feature
    - Time and Skill Constraints
3. Extensive J Unit tests of all classes
    - Unable to make J unit tests working prompted the abandonment of idea
4. Local Multiplayer
    - Level and User packages require more refactoring before implementation to prevent unwanted complexity and "Spaghetti code"
5. Multiple Bullet types
    - Implementation of seeking projectiles or shield piercing projectile abandoned due to difficulty in implementation
    
## New Java Classes
- JUnit Test Cases
    - shieldTest
    - levelParent
    - mainTest
  
- Controllers Package
  - MainMenuController
  - HowToPlayController
  - HowToPlayController
  - SceneManager
  - StageConfig

- Actor Package
  - RemovalReason

- Utility Package
  - SoundPlayer

- Level Package
  - LevelThree
  
- Player
  - CharacterData
  - CharacterRepository

- Ability Package
  - Ability
  - InvincibilityAbility
  - SpeedBoostAbility

## Modified Java Classes:
- Main
- Controllers Package
    - Controller (renamed to GameController)
- showImage Package
    - GameOverImage
    - ShieldImage
- Level Package
    - LevelOne
    - LevelTwo
    - LevelView
    - LevelParent
- Enemy Package
    - Boss
- Player
    - UserPlane

## Unexpected Problems
Movement Left and Right of userPlane not working
Removal system not working
### 1. Bugs in initial project
- **Problem**: 
  - Enemy Removal via out of bounds counted as kills
    - This is because the game cannot differentiate whether an enemy was killed via projectile or out of bounds (Penetrated Defenses) when incrementing the killCount 
  - Boss shield not showing
    - Incorrect file type specified
    - Logic not coded properly
  - GameOver Image too large
    - GameOver Image covered whole screen
  - Game crashing during level transition
    - Timeline of level is not stopped during level transition
  - Player is still able to shoot after game has ended
    - Game still checks for key presses even when game is over
- **Solution**: 
    - Out of Bounds causing kills to increment
      - Implemented DecrementKillCount method to lower enemy count to counter the incrementing during Penetrated Defenses
    - Boss shield not showing
      - Changed specified file to the correct type (jpg to png)
      - Implemented logic to show shield
    - GameOver Image too large
      - Utilise code that displayed the WinImage to display the GameOver Image instead
    - Game crashing during level Transition
      - Ensured timeline() was stopped before level transition
    - Shooting after game has ended
      - Implement Check for if game ended and if it is prevent key events from triggering 
### 2. J-Unit tests not functioning
- **Problem**
  - Frequent failing to implementing of J-Unit Tests
- **Solution**
    - Writing tests abandoned
    - Running program to and checking for problems was more efficient

### 3. Problems with branching
- **Problem**: IntelliJ could not recognise branch has been changed and would keep editing in master even if the built in git feature was used.
  - Performing git add and commit still results in changes being put under master branch
  - This resulted in the menu system breaking after attempts to refactor it

- **Solution**: Avoid using branches entirely
  - Earlier solutions from internet were to refresh and restart which did not work.
  - Attempting by reindexing the project did not work.
  - Last ditch effort using the built in git features under the Git tab instead of in editor terminal also did not work. 

### 4. Character System Integration
- **Problem**: Difficulty in figuring out integration steps due to issues with modularity faced in attempting to refactor the Level package whereby making health property player defined in UserPlane/CharacterPlane instead of LevelOne , LevelTwo etc.
      - Added difficulty in figuring out establishing communication between CharacterSelectMenu and the UserPlane class in player package before figuring out how to inject a UserPlane / CharacterPlane into LevelOne/LevelParent
- **Solution**: Refactored Level classes to accept CharacterData as a paramater to use to set the properties of userPlane
  -  Additional problem was found to be refactoring of LevelView and was called before constructor could finish creating instance of LevelOne
  - The InstantiateLevelView had to be refactored to be ran when called by secondary method InitialiseLevelView after the Level is instantiated.

### 5. Ability System
- **Problem**: Difficulty to integrate the ability system due to knock on effect of unable to implement character system.
  - **Solution** Implement ability system after character system is verified to be functional
- **Problem** Frame based cooldown and duration seemed inconsistent with real world time
  - **Solution** Introduced a second kind of implementation utilising system time to track duration and cooldown 

### 6. Horizontal Movement not working
- **Problem**: Used logic similar to Vertical movement for implementation but couldn't seem to make Horizontal movement possible
- **Solution**: Left alone due to time constraints as the game had no problems running despite the issue.

## Deliverables
Named Folder as: COMP2042surnameFirstname

    [x] README.md
    [ ] Design.pdf
    [x] javadoc
    [ ] Demo.mp4
    [ ] SurnameFirstName_IDE_JavaVersion.zip

    
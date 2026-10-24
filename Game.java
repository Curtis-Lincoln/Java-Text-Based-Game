import java.util.Scanner; 

public class Game { 
    //Variables to keep track of if the doors are locked
    static boolean frontDoorLocked = true;
    static boolean passagewayLocked = true;
    static boolean safeLocked = true;
    
    public static void main(String args[]) {
        // Room objects
        Position courtPos = new Position(3,0);
        Room courtyard = new Room("Courtyard", "There is nothing but old, ruined statues surrouding you and the door to the mansion to the" + "\u001B[91m" + " south" + "\u001B[0m"+ ".", 'c', courtPos);
        Position frontPos = new Position(3,1);
        Room frontDoor = new Room("Front Door", "You are standing on the steps at the front door of the mansion. To the left of you there is a large doorbell marked with" + "\u001B[91m" + " 'use doorbell to be let in'" + "\u001B[0m" + " written on it. Under the doorbell, there is a panel that says that the door is" + "\u001B[91m" + " 'locked'" + "\u001B[0m" + ".", 'f', frontPos);
        Position entrywayPos = new Position(3,2);
        Room entryway = new Room("Entryway", "You stand in the entryway with the murder scene to the" + "\u001B[91m" + " south" + "\u001B[0m" + " of you.", 'e', entrywayPos);
        Position hallPos = new Position(3,3);
        Room hall = new Room("Hall", "You are at the scene of the crime in the hall. A" + "\u001B[91m" + " detective" + "\u001B[0m" + " stands examining the" + "\u001B[91m" + " deadbody" + "\u001B[0m" + " with the initial report of what happened; they are ready to" + "\u001B[91m" + " talk" + "\u001B[0m" + " to you. There \nis the garage to the" + "\u001B[91m" + " east" + "\u001B[0m" + ", the hallway to the" + "\u001B[91m" + " west" + "\u001B[0m" + " and the stairway to the upper floor of the mansion to the" + "\u001B[91m" + " south" + "\u001B[0m" +  " of you.", 'h', hallPos);
        Position garPos = new Position(4,3);
        Room garage = new Room("Garage", "Standing in the garage, it is very organised with tools and equipment neatly placed. There is a" + "\u001B[91m" + " car" + "\u001B[0m" + " with a cover over the top of it in the centre of the room. Over on \nthe" + "\u001B[91m" + " toolrack" + "\u001B[0m" + " all the tools are precisely placed, however one tool seems to be misplaced. There is no way out of the garage other than the passageway.", 'g', garPos);
        Position hallwayPos = new Position(2,3);
        Room hallway = new Room("Hallway", "In the hallway the walls and cabinets are decorated with lots of pictures of the guests togther. There is one" + "\u001B[91m" + " picture" + "\u001B[0m" + " in a special frame that shows Plum and Peacock \ntogether on a holiday. There is some writing on the back of the picture. To the" + "\u001B[91m" + " west" + "\u001B[0m" + " of you there is the lounge.", 'w', hallwayPos);
        Position loungePos = new Position(1,3);
        Room lounge = new Room("Lounge", "\u001B[91m" + "Peacock" + "\u001B[0m" + " is sitting by the fireplace waiting to be" + "\u001B[91m" + " talked" + "\u001B[0m" +  " to. She is wearing an expensive ring that she was not seen wearing in some of the pictures around the house. The dining room is to the" + "\u001B[91m" + " south" + "\u001B[0m" + " of you. ", 'l', loungePos);
        Position dinPos = new Position(1,4);
        Room diningRoom = new Room("Dining Room", "In the dining room everything is set out from when all the guests had dinner together. However one of the" + "\u001B[91m" + " candlesticks" + "\u001B[0m" + " is not in the position on the table it was \noriginally laid out in." + "\u001B[91m" + " Green" + "\u001B[0m" + " is sitting at the end of the table waiting to be interviewed. The billard room is to the" + "\u001B[91m" + " west" + "\u001B[0m" + " and the kitchen is to the" + "\u001B[91m" +  " south" + "\u001B[0m" + ". ", 'd', dinPos);
        Position kitchPos = new Position(1,5);                                    
        Room kitchen = new Room("Kitchen", "The kitchen is splotless with everything stacked and neatly tidied away. Sticking out from underneath the fridge there is a" + "\u001B[91m" + " key that looks like it opens one of the \npantries in the corner of the room" + "\u001B[0m" + ". There are no other rooms attached.", 'k', kitchPos);
        Position billPos = new Position(0,4);
        Room billardRoom = new Room("Billard Room", "Waiting by the billiard table is" + "\u001B[91m" + " Mustard who is prepared to be talked to" + "\u001B[0m" + ". On the far side of the wall, there is a trophy" + "\u001B[91m" + " cabinet" + "\u001B[0m" + " which one of the trophies in it looks \nout of place. There are no other rooms attached.", 'b', billPos);
        Position upstairsPos = new Position(3,4);
        Room upstairs = new Room("Upstairs", "The stairs lead to the bedroom to the" +"\u001B[91m" + " south" + "\u001B[0m" + " of you.", 'u', upstairsPos);
        Position bedPos = new Position(3,5);
        Room bedroom = new Room("Bedroom", "\u001B[91m" + "Scarlet" + "\u001B[0m" + " is sitting at the desk waiting to be" + "\u001B[91m" + " talked" + "\u001B[0m" + " to. Under the bed, there is a" + "\u001B[91m" + " letter" + "\u001B[0m" + " sticking out. To the" + "\u001B[91m" + " east" + "\u001B[0m" + " there is the bathroom and to the" + "\u001B[91m" + " south" + "\u001B[0m" + " is the study", 'B', bedPos);
        Position bathPos = new Position(4,5);
        Room bathroom = new Room("Bathroom", "The bathroom is quite empty with only a few hair and body products on the side. There is dented" + "\u001B[91m" + " leadpipe" + "\u001B[0m" + " that was left on the side as well. There are no other rooms \nattached.", 't', bathPos);
        Position studyPos = new Position(3,6);
        Room study = new Room("Study", "In Plum's study there are lots of his accomplishments hung on the walls. On his desk there is a" + "\u001B[91m" + " notebook" + "\u001B[0m" + " that had many pages marked as important. In the corner of his \nstudy there is a small" + "\u001B[91m" + " safe" + "\u001B[0m" + " that was left out on top of the drawer. It looks like you need to use a" + "\u001B[91m" + " 6 digit code" + "\u001B[0m" + " to unlock the safe.", 's', studyPos);

        // An array of rooms to iterate through to check if a move if valid in a certain direction
        Room[] rooms = {courtyard, frontDoor, entryway, hall, garage, hallway, lounge, diningRoom, kitchen, billardRoom, upstairs, bedroom, bathroom, study};
        // Other necessary objects for the game to work
        Position character = new Position(3,0);
        Inventory inventory = new Inventory();
        Score score = new Score(100);
        Map map = new Map(7,7);
        map.placeRoom(courtPos, 'c');

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean stop = false;
        
       //Intro to the game 
        System.out.println("************************************************************************************************************************************************************************");
        System.out.println("Cluedo inspired text-based game"); 
        System.out.println("Aim of the game is to deduce who the murderer is out of the four suspects, what weapon they used and the motive for the crime.");
        System.out.println("Valid commands are: <move> <direction>, <look>, <look> <feature>, <look> <item>, <talk> <person>, <drop> <item>, <take> <item>, <use> <object>, <solve>, <inventory>, \n<score>, <map>, <help> and <quit>");
System.out.println("************************************************************************************************************************************************************************");
        

        System.out.println("A murder has occured and you have been called in to interview the occupants of the house at the time and" + "\u001B[91m" + " find out who committed the crime, with what weapon and what the motive for the murder was." + "\u001B[0m" + " Discover clues arround the house and explore each room to find out the mysteries and secrets that the occupants are hiding.");
        System.out.println();
        System.out.println("You arrive at the grand, decrepit mansion. You are standing in the courtyard with the front door to the" + "\u001B[91m" + " south" + "\u001B[0m" + " of you.");
        // Game loop: if stop if false after every command it will ask for another input from the player
        while(!stop){
            System.out.print(">> ");
            userInput = scanner.nextLine().toLowerCase();
            // Enhanced switch to check which command the player has entered
            switch (userInput){
                case "move north" -> move("n", character, rooms, map, score);
                case "move east" -> move("e", character, rooms, map, score);
                case "move south" ->  move("s", character, rooms, map, score);
                case "move west" -> move("w", character, rooms, map, score);
                case "look" -> look(character, rooms);
                case "look deadbody", 
                     "look car",
                     "look toolrack",
                     "look table",
                     "look cabinet",
                     "look notebook" -> lookFeature(userInput, character);
                case "look key",
                     "look letter",
                     "look picture",
                     "look phone",
                     "look ring", 
                     "look candlestick",
                     "look wrench",
                     "look leadpipe",
                     "look trophy" -> lookItem(userInput, inventory);
                case "talk detective",
                     "talk mustard",
                     "talk peacock",
                     "talk green",
                     "talk scarlet" -> talk(userInput, character);
                case "drop key",
                     "drop letter",
                     "drop picture",
                     "drop phone",
                     "drop ring",
                     "drop candlestick",
                     "drop wrench",
                     "drop leadpipe",
                     "drop trophy" -> drop(userInput, inventory);
                case "take key",
                     "take letter",
                     "take picture",
                     "take phone",
                     "take ring",
                     "take candlestick",
                     "take wrench",
                     "take leadpipe",
                     "take trophy" -> take(userInput, inventory, character);  
                case "use key",
                     "use passageway",
                     "use doorbell",
                     "use safe" -> use(userInput, inventory, rooms, character, map, score, scanner);
                case "solve" -> {
                    if(solve(scanner, score)){
                        stop = true;
                    }
                }
                case "inventory" -> System.out.println("Inventory: " + inventory.displayInventory());
                case "score" -> System.out.println(score.getScore());
                case "map" -> System.out.println(map.display());
                case "help" -> System.out.println("Valid commands are: <move> <direction>, <look>, <look> <feature>, <look> <item>, <talk> <person>, <drop> <item>, <take> <item>, <use> <object>, <solve>, <inventory>, \n<score>, <map>, <help> and <quit>");
                case "quit" -> stop = true;
                default -> System.out.println("Not a valid command");
            }
        }
        System.out.println("Game Over!");
    }
    // Move method checks if the move that the player wants to do is valid and then moves the position of the player in the specified direction
    public static void move(String direction, Position character, Room[] rooms, Map map, Score score){
        boolean valid = false;
        if(direction == "n"){
            for(int i = 0; i < rooms.length; i++){
                // Checks that there is a room in the north direction
                if(rooms[i].getPosition().x == character.x && rooms[i].getPosition().y == character.y - 1){
                    // Moves the player north, updates the map and score and sets valid to true
                    character.y--;
                    System.out.printf("You go north to the %s\n", rooms[i].getName());
                    map.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                    score.visitRoom();
                    valid = true;
                    break;
                }
            }
        }
        else if(direction == "e"){
            // If the player is in the hall they cannot move east as the door is blocked so this is checked first
            if(!(character.x == 3 && character.y == 3)){
                for(int i = 0; i < rooms.length; i++){
                    // Checks that there is a room in the east direction
                    if(rooms[i].getPosition().x == character.x + 1 && rooms[i].getPosition().y == character.y){
                        // Moves the player east, updates the map and score and sets valid to true
                        character.x++;
                        System.out.printf("You go east to the %s\n", rooms[i].getName());
                        map.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                        score.visitRoom();
                        valid = true;
                        break;
                    }
                }
            }
            else{
                System.out.println("The door is locked with the key nowhere to be found");
            }
        }
        else if(direction == "s"){
            // If the player is at the front door they cannot move south until the door is unlocked so this is checked first
            if(!((character.x == 3 && character.y == 1) && frontDoorLocked)){
                for(int i = 0; i < rooms.length; i++){
                    // Checks that there is a room in the south direction
                    if(rooms[i].getPosition().x == character.x && rooms[i].getPosition().y == character.y + 1){
                        // Moves the player south, updates the map and score and sets valid to true
                        character.y++;
                        System.out.printf("You go south to the %s\n", rooms[i].getName());
                        map.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                        score.visitRoom();
                        valid = true;
                        break;
                    }
                }
            }
            else{
                System.out.println("The door is locked");
            }
        }
        else if(direction == "w"){
            // If the player is in the garage they cannot move west as the door is blocked so this is checked first
            if(!(character.x == 4 && character.y == 3)){
                for(int i = 0; i < rooms.length; i++){
                    // Checks that there is a room in the west direction
                    if(rooms[i].getPosition().x == character.x - 1 && rooms[i].getPosition().y == character.y){
                        // Moves the player west, updates the map and score and sets valid to true
                        character.x--;
                        System.out.printf("You go west to the %s\n", rooms[i].getName());
                        map.placeRoom(rooms[i].getPosition(), rooms[i].getSymbol());
                        score.visitRoom();
                        valid = true;
                        break;
                    } 
                }
            }
        }
        // If no valid move was made then this message is printed
        if(!valid){
            System.out.println("You cannot go this way!");
        }
    }
    
    // Look method prints the description of the room to the console
    public static void look(Position character, Room[] rooms){
        for(int i = 0; i < rooms.length; i++){
            // Checks what room the player is in
            if(rooms[i].getPosition().x == character.x && rooms[i].getPosition().y == character.y){
                System.out.println(rooms[i].getDescription());
            }
        }
    }

    // lookFeature method prints the description of the feature in the room to the console
    public static void lookFeature(String userInput, Position character){
        // Enhanced switch checks which feature the player wants to look at
        switch (userInput){
            case "look deadbody" -> {
                // Checks if the player is in the right room to look at the feature
                if(character.x == 3 && character.y == 3){
                    System.out.println("The body does not have any other wounds on the body showing that the victim and the suspect did not fight beforehand. The cause of death was" + "\u001B[91m" + " blunt force trauma" + "\u001B[0m" + " to the \nhead with a" + "\u001B[91m" + " heavy blunt object" + "\u001B[0m" + ".");
                }
                else{
                    System.out.println("This feature is not in this room");
                }
            }
            case "look car" -> {
                if(character.x == 4 && character.y == 3){
                    System.out.println("There is a Aston Martin DB5 under the cover of the car. Also you notice that the missing tool, a" + "\u001B[91m" + " wrench" + "\u001B[0m" + ", is sticking out from under the bottom the car, slightly hidden away. You can" + "\u001B[91m" + " take the wrench" + "\u001B[0m" + " to examine it more closely");
                }
                else{
                    System.out.println("This feature is not in this room.");
                }
            }
            case "look table" -> {
                if(character.x == 1 && character.y == 4){
                    System.out.println("The table has candlesticks laid out symmetrically up the middle of the table however" + "\u001B[91m" + " one has been misplaced" + "\u001B[0m" + " and is not in line with the others. It must have been moved \nrecently. You can" + "\u001B[91m" + " take the candlestick" + "\u001B[0m" + " to examine it more closely.");
                }
                else{
                    System.out.println("This feature is not in this room");
                }
            }
            case "look toolrack" -> {
                if(character.x == 4 && character.y == 3){
                    System.out.println("Over on the toolrack, the tools and equipment are arranged in an organised fashion. However, there is" + "\u001B[91m" + " one tool missing from the set" + "\u001B[0m" + ". It is not obvious whether this tool has been" + "\u001B[91m" + " misplaced or hidden" + "\u001B[0m" + ".");
                }
                else{
                    System.out.println("This feature is not in this room.");
                }
            }
            case "look cabinet" -> {
                if(character.x == 0 && character.y == 4){
                    System.out.println("In the trophy cabinet all the trophies and plaques are neatly polished and are in perfect condition with no traces of dust on them. However," + "\u001B[91m" + " one of the trophies doesn't match the rest and is broken at the handle" + "\u001B[0m" + ". You can" + "\u001B[91m" + " take the trophy" + "\u001B[0m" + " to examine it more closely.");
                }
                else{
                    System.out.println("This feature is not in this room.");
                }
            }
            case "look notebook" -> {
                if(character.x == 3 && character.y == 6){
                    System.out.println("The notebook has lots of scribbles and circles around money transactions that Plum made that do not add up. In the top right of the page, there is a 6 digit number underlined," + "\u001B[91m" + " 437195" + "\u001B[0m" + ", that do not match the other numbers underlined." + "\u001B[91m" + " This number might be for something else" + "\u001B[0m" + ".");
                }
                else{
                    System.out.println("This feature is not in this room.");
                }
            }
            default -> System.out.println("Not a valid command");
        }
    }

    // lookItem methods prints the description of the item to the console
    public static void lookItem(String userInput, Inventory inventory){
        // Splits the userinput into two to find out what item the player wants to look at
        String[] words = userInput.split("\\s+");
        if(words.length == 2){
            // Checks if the player has the item they want to look at
            if(inventory.hasItem(words[1]) != -1){
                switch (words[1]){
                    case "key" -> System.out.println("The key looks very old and rusty. You can" + "\u001B[91m" + " use the key" + "\u001B[0m" + " to unlock the pantry in the corner of the kitchen.");
                    case "letter" -> System.out.println("The letter is from an anonymous source to Plum. It states that" + "\u001B[91m" + " Scalet" + "\u001B[0m" + " may have been up to some bad things behind Plum's back using his" + "\u001B[91m" + " money" + "\u001B[0m" + ". At the end of the letter, \nit says that more proof is to come. There is no indication of who the letter is from.");
                    case "picture" -> System.out.println("The picture shows the victim" + "\u001B[91m" + " Plum and Peacock" + "\u001B[0m" + " on a beach together on holiday. They appear to be in a" + "\u001B[91m" + " relationship" + "\u001B[0m" + ". The writing on the back says" + "\u001B[91m" + " 'for my love P from P'" + "\u001B[0m" + ".");
                    case "phone" -> System.out.println("The last thing on the phone was an email from the anonymous source with evidence of" + "\u001B[91m" + " Scarlet embezzling money from Plum" + "\u001B[0m" + " which he thought was investments into her company. It looks like Plum kept this phone safe from Scarlet to stop her from getting rid of the evidence. It appears that Plum wanted to confront Scarlet to get his" + "\u001B[91m" + " money" + "\u001B[0m" + " back.");
                    case "ring" -> System.out.println("The ring is an" + "\u001B[91m" + " engagement ring" + "\u001B[0m" + " from Plum to Peacock. It has engraved the words" + "\u001B[91m" + " 'always and forever'" + "\u001B[0m" + " on the inside.");  
                    case "candlestick" -> System.out.println("The candlestick" + "\u001B[91m" + " doesn't have any dents or blood stains on it" + "\u001B[0m" + ". The candle inside of it has been" + "\u001B[91m" + " newly replaced" + "\u001B[0m" + ", this must ben the reason for why it was" + "\u001B[91m" + " misplaced" + "\u001B[0m" + ".");
                    case "wrench" -> System.out.println("The wrench was hidden under the car cover. It looks recently cleaned besides" + "\u001B[91m" + " one blood spot" + "\u001B[0m" + " that was missed on the inside of the jaw of the wrench.");
                    case "trophy" -> System.out.println("The trophy is broken at the handle, however there are" + "\u001B[91m" + " no visible dents" + "\u001B[0m" + " on it. It looks like the" + "\u001B[91m" + " trophy was broken by it getting dropped on the floor than being used as a weapon" + "\u001B[0m" + ".");
                    case "leadpipe" -> System.out.println("The leadpipe is dented in the middle and is very rusty. It looks like it from the drainage system outside." + "\u001B[91m" + " If this was used as the weapon traces of rust would have been found in the victim's hair" + "\u001B[0m" + "."); 
                    default -> System.out.println("Not a valid command");
                }
            }
            else{
                System.out.println("Not a valid command");
            }
        }
        else{
            System.out.println("Not a valid command");
        }
    }

    // talk method prints the description of the conversation to the console
    public static void talk(String userInput, Position character){
        // Enhanced switch checks which person the player wants to talk to
        switch(userInput){
            case "talk detective" -> {
                // Checks if the player is in the correct room to talk to the person
                if(character.x == 3 && character.y == 3){
                    System.out.println("In the detective's initial report they found that the victim is" + "\u001B[91m" + " Professor Plum" + "\u001B[0m" + " who was meeting" + "\u001B[91m" + " Mustard, Peacock, Green and Scarlet" + "\u001B[0m" + " for dinner to discuss an important \nbusiness decision. These were the only people in the house at the time of the murder. Plum died of a" + "\u001B[91m" + " blunt force trauma" + "\u001B[0m" + " to the head and he is" + "\u001B[91m" + " missing his phone" + "\u001B[0m" + ", but all \nother personal belongings are accounted for.");
                }
                else{
                    System.out.println("The person is not in this room.");
                }
            }
            case "talk mustard" -> {
                if(character.x == 0 && character.y == 4){
                    System.out.println("Mustard said that Plum asked him to help confront Scarlet about something but didn't tell him what, hence the argument they all had as" + "\u001B[91m" + " Scarlet was not having any of it" + "\u001B[0m" + ". Plum said to Mustard that he would try again later that day." + "\u001B[91m" + " Mustard was trying to find Plum until he found his dead body in the hall" + "\u001B[0m" + ".");
                }
                else{
                    System.out.println("This person is not in this room.");
                }
            }
            case "talk green" -> {
                if(character.x == 1 && character.y == 4){
                    System.out.println("Green said that he was best friends with Plum and met each other all the way back in high school. Apparently he heard" + "\u001B[91m" + " Plum, Scarlet and Mustard having an argument" + "\u001B[0m" + " but \ncouldn't hear what it was about. He says" + "\u001B[91m" + " he was in the dining room at the time of the murder" + "\u001B[0m" + " setting the table and cleaning up after the dinner the group had.");
                }
                else{
                    System.out.println("This persin is not in this room.");
                }
            }
            case "talk peacock" -> {
                if(character.x == 1 && character.y == 3){
                    System.out.println("Peacock explained that she was in a" + "\u001B[91m" + " secret relationship with Plum" + "\u001B[0m" + " and that she was going to be married to him next summer. She was about to announced the engagement to \nthe group tomorrow. She said that you could" + "\u001B[91m" + " take her ring" + "\u001B[0m" + " as she does not want a constant reminder of the love that she lost. She says that" + "\u001B[91m" + " she was reading her book by \nthe fireplace in the lounge all night when the murder occured" + "\u001B[0m" + ".");
                }
                else{
                    System.out.println("This person is not in this room.");
                }
            }
            case "talk scarlet" -> {
                if(character.x == 3 && character.y == 5){
                    System.out.println("\u001B[91m" + "Scarlet denies what the letter could be about" + "\u001B[0m" + " and has no idea what this anonymous person could be on about. She admits to" + "\u001B[91m" + " arguing with Plum when they met earlier" + "\u001B[0m" + " but \nsays that she never saw him again that night." + "\u001B[91m" + " She claims to have been in the Kitchen at the time of the murder" + "\u001B[0m" + " but no one could corroborate her alibi.");
                }
                else{
                    System.out.println("This person is not in this room.");
                }
            }
            default -> System.out.println("Not a valid command");
        }

    }

    // drop method removes the item from the player's inventory
    public static void drop(String userInput, Inventory inventory){
        String[] words = userInput.split("\\s+");
        if(words.length == 2){
            // Checks if the player has the item in their inventory
            if(inventory.hasItem(words[1]) != -1){
                switch (words[1]){
                    case "key" -> {
                        // The item gets removed from the player's inventory and a message is displayed that the item has been dropped
                        System.out.println("You dropped the key to the pantry");
                        inventory.removeItem("key");
                    }
                    case "letter" -> {
                        System.out.println("You dropped the letter.");
                        inventory.removeItem("letter");
                    }
                    case "picture" -> {
                        System.out.println("You dropped the picture."); 
                        inventory.removeItem("picture");
                    }
                    case "phone" -> {
                        System.out.println("You dropped the phone.");
                        inventory.removeItem("phone");
                    }
                    case "ring" -> {
                        System.out.println("You dropped the ring.");
                        inventory.removeItem("ring"); 
                    }
                    case "candlestick" -> {
                        System.out.println("You dropped the candlestick");
                        inventory.removeItem("candlestick");
                    }
                    case "wrench" -> {
                        System.out.println("You dropped the wrench.");
                        inventory.removeItem("wrench");
                    }
                    case "trophy" -> {
                        System.out.println("You droppped the trophy.");
                        inventory.removeItem("trophy");
                    }
                    case "leadpipe" -> {
                        System.out.println("You droppped the trophy.");
                        inventory.removeItem("trophy");
                    }
                    default -> System.out.println("Not a valid command");
                }
            }
            else{
                System.out.println("Not a valid command");
            }
        }
        else{
            System.out.println("Not a valid command");
        }
    }

    // take method add the item to the player's inventory
    public static void take(String userInput, Inventory inventory, Position character){
        String[] words = userInput.split("\\s+");
        if(words.length == 2){
            // Checks if the player already has the item
            if(inventory.hasItem(words[1]) == -1){
                switch (words[1]){
                    // Checks that the player is in the right room to pick up the item
                    case "key" -> {
                        if(character.x == 1 && character.y == 5){
                            // Adds the item to the player's inventory and displays a message that the item has been picked up
                            System.out.println("You picked up the key for the pantry");
                            inventory.addItem("key");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "letter" -> {
                        if(character.x == 3 && character.y == 5){
                            System.out.println("You picked up the letter.");
                            inventory.addItem("letter");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "picture" -> {
                        if(character.x == 2 && character.y == 3){
                            System.out.println("You picked up the picture.");
                            inventory.addItem("picture");
                        }
                        else{
                            System.out.println("This item is not in this room");
                        }
                    }
                    case "phone" -> {
                        if(character.x == 3 && character.y == 6){
                            if(!safeLocked){
                                System.out.println("You picked up the phone.");
                                inventory.addItem("phone");
                            }
                            else{
                                System.out.println("The safe is locked.");
                            }
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "ring" -> {
                        if(character.x == 1 && character.y == 3){
                            System.out.println("You picked up the ring.");
                            inventory.addItem("ring");
                        }
                        else{
                            System.out.println("This item is not in this room");
                        }
                    } 
                    case "candlestick" -> {
                        if(character.x == 1 && character.y == 4){
                            System.out.println("You picked up the candlestick");
                            inventory.addItem("candlestick");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "wrench" -> {
                        if(character.x == 4 && character.y == 3){
                            System.out.println("You picked up the wrench");
                            inventory.addItem("wrench");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "trophy" -> {
                        if(character.x == 0 && character.y == 4){
                            System.out.println("You picked up the trophy");
                            inventory.addItem("trophy");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    case "leadpipe" -> {
                        if(character.x == 4 && character.y == 5){
                            System.out.println("You picked up the leadpipe");
                            inventory.addItem("leadpipe");
                        }
                        else{
                            System.out.println("This item is not in this room.");
                        }
                    }
                    default -> System.out.println("Not a valid command");
                }
            }
            else{
                System.out.println("You already have the item in your inventory");
            }
        }
        else{
            System.out.println("Not a valid command");
        }
    }

    // use method is for the puzzles that the player has to complete to unlock rooms/doors
    public static void use(String userInput, Inventory inventory, Room[] rooms, Position character, Map map, Score score, Scanner scanner){
        String[] words = userInput.split("\\s+");
        if (words.length == 2){
            // If the player uses the doorbell then the description of the Front Door changes to say that the front door is now unlocked
            if(words[1].equals("doorbell")){
                System.out.println("You used the doorbell");
                rooms[1].setDescription("You are standing on the steps at the front door of the mansion. To the left of you there is a large doorbell marked with" + "\u001B[91m" + " 'use doorbell to be let in'" + "\u001B[0m" + " written on it. Under the doorbell, there is a panel that says that the door is" + "\u001B[91m" + " 'unlocked'" + "\u001B[0m" + ".");
                // Allows the player to enter the house 
                frontDoorLocked = false;
                // Adds points to the player's score for completing the puzzle
                score.solvePuzzle();
            }
            else if(words[1].equals("key")){
                // Checks if the passageway is already unlocked
                if(passagewayLocked){
                    // Checks that the player has a key to unlock the passageway
                    if(inventory.hasItem(words[1]) != -1){
                        // Checks if the player is in the right room
                        if(character.x == 1 && character.y == 5){
                            // Unlocks the passageway and displays to the player that they have unlocked a secret passageway
                            passagewayLocked = false;
                            System.out.println("You use the key on the pantry door in the corner of the kitchen");
                            System.out.println("It revealed a secret" + "\u001B[91m" + " passageway" + "\u001B[0m" + " that you could" + "\u001B[91m" + " use" + "\u001B[0m" + ", but it is not obvious where it leads.");
                            score.solvePuzzle();
                        }
                        else{
                            System.out.println("You cannot use the key in this room.");
                        }
                    }
                    else{
                        System.out.println("This item is not in your inventory.");
                    }
                }
                else{
                    System.out.println("The secret passageway is already unlocked.");
                }
            }
            else if(words[1].equals("passageway"))
            {
                if(!passagewayLocked){
                    // Checks which way the player wants to use the passageway
                    // If the player is in the kitchen and uses the passageway
                    if(character.x == 1 && character.y == 5){
                        // Change their position to be in the garage
                        character.x = 4;
                        character.y = 3;
                        // Update the map and score
                        System.out.println("You used the passage way and it has led you to the garage.");
                        map.placeRoom(rooms[4].getPosition(), rooms[4].getSymbol());
                        score.visitRoom();
                    }
                    // If the player is in the garage and uses the passageway
                    else if (character.x == 4 && character.y == 3){
                        // Change their position to be in the kitchen
                        character.x = 1;
                        character.y = 5;
                        System.out.println("You used the passage way and it has led you to the kitchen.");
                        score.visitRoom();
                    }
                    else{
                        System.out.println("You are not in the right room to use the passageway.");
                    }
                }
                else{
                    System.out.println("The passageway is locked.");
                }   
            }
            else if(words[1].equals("safe"))
            {
                // Checks if the safe has already been unlocked
                if(safeLocked){
                    // Checks that the player is in the right room
                    if(character.x == 3 && character.y == 6){
                        // Asks the player to type in the code for the safe
                        System.out.print("Type in the code for the safe: ");
                        int code = scanner.nextInt();
                        scanner.nextLine();
                        // If the code is right then the safe is unlocked and a message is displayed to the player 
                        if(code == 437195){
                            safeLocked = false;
                            System.out.println("You unlocked the safe.");
                            System.out.println("There is a single item in the safe. There is Plum's" + "\u001B[91m" + " phone" + "\u001B[0m" + " which you can" + "\u001B[91m" + " take" + "\u001B[0m" + " and examine it more closely,");
                            // Updates the score for solving the puzzle
                            score.solvePuzzle();
                        }
                        else{
                            System.out.println("Code incorrect");
                        }
                    }
                    else{
                        System.out.println("The safe is not in this room.");
                    }
                }
                else{
                    System.out.println("The safe is already unlocked.");
                }
            }
         else{
            System.out.println("Not a valid command.");
        }
        }
    }

    // solve method is used for when the player is ready to solve the case
    public static boolean solve(Scanner scanner, Score score){
        // Asks the player for who they think the suspect is, what the weapon was and what was thier motive for the crime.
        System.out.print("Who murdered the victim?: ");
        String murderer = scanner.nextLine().toLowerCase();
        System.out.print("What was the weapon?: ");
        String weapon = scanner.nextLine().toLowerCase();
        System.out.print("What was the motive?: ");
        String motive = scanner.nextLine().toLowerCase();
        // If the player guesses correctly then the game ends and the player's score is displayed to them
        if (murderer.equals("scarlet") && weapon.equals("wrench") && motive.equals("money")){
            score.solvePuzzle();
            System.out.println("You have solved the murder.");
            System.out.println("Scarlet killed Plum with the wrench because he wanted his money back after she was found embezzeling from him.");
            System.out.println("Plum found Scarlet in the garage, where they had an argument, which ended when Scarlet hit Plum around the head with the wrench. Then Plum stumbled into the Hall where \nhe died of his injuries, while Scarlet tried to clean the wrench and hid it under the car. After that Scarlet locked the garage, throwing the key away and used the \npassageway to then up in the Kitchen.");
            System.out.println(score.getScore());
            return true;
        }
        else{
            System.out.println("That is an incorrect guess.");
            return false;
        }
    }       
}

package com.crafts;

import java.util.*;
/**
 * Hello world!
 *
 */

class SpaceCraft {
    int x, y, z;
    char direction;

    SpaceCraft(int x, int y, int z, char dir) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = dir;
    }
}

public class App 
{
	static void moveForward(SpaceCraft lunarCraft) {
        switch (lunarCraft.direction) {
            case 'N':
                lunarCraft.y++;
                break;
            case 'S':
                lunarCraft.y--;
                break;
            case 'E':
                lunarCraft.x++;
                break;
            case 'W':
                lunarCraft.x--;
                break;
            case 'U':
                lunarCraft.z++;
                break;
            case 'D':
                lunarCraft.z--;
                break;
        }
    }

    static void moveBackward(SpaceCraft lunarCraft) {
        switch (lunarCraft.direction) {
            case 'N':
                lunarCraft.y--;
                break;
            case 'S':
                lunarCraft.y++;
                break;
            case 'E':
                lunarCraft.x--;
                break;
            case 'W':
                lunarCraft.x++;
                break;
            case 'U':
                lunarCraft.z--;
                break;
            case 'D':
                lunarCraft.z++;
                break;
        }
    }

    static void turnLeft(SpaceCraft lunarCraft) {
        Map<Character, Character> mapLeft = new HashMap<>();
        mapLeft.put('U', 'W');
        mapLeft.put('W', 'S');
        mapLeft.put('S', 'E');
        mapLeft.put('E', 'N');
        mapLeft.put('N', 'W');
        mapLeft.put('D', 'E');

        lunarCraft.direction = mapLeft.get(lunarCraft.direction);
    }

    static void turnRight(SpaceCraft lunarCraft) {
        Map<Character, Character> mapRight = new HashMap<>();
        mapRight.put('U', 'E');
        mapRight.put('E', 'S');
        mapRight.put('S', 'W');
        mapRight.put('W', 'N');
        mapRight.put('N', 'E');
        mapRight.put('D', 'W');

        lunarCraft.direction = mapRight.get(lunarCraft.direction);
    }
    
    static void translateCommand(SpaceCraft lunarCraft, List<Character> commands) {
        for (char curr : commands) {
            switch (curr) {
                case 'f':
                    moveForward(lunarCraft);
                    break;
                case 'b':
                    moveBackward(lunarCraft);
                    break;
                case 'l':
                    turnLeft(lunarCraft);
                    break;
                case 'r':
                    turnRight(lunarCraft);
                    break;
                case 'u':
                    lunarCraft.direction = 'U';
                    break;
                case 'd':
                    lunarCraft.direction = 'D';
                    break;
            }
        }
    }
    
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial position as (x, y, z): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        System.out.print("Enter initial direction: ");
        char initialDir = scanner.next().charAt(0);

        SpaceCraft lunarCraft = new SpaceCraft(x, y, z, initialDir);

        System.out.print("Enter number of commands: ");
        int noOfCommands = scanner.nextInt();

        System.out.print("Enter space-separated commands: ");
        List<Character> commands = new ArrayList<>();
        for (int i = 0; i < noOfCommands; i++) {
            commands.add(scanner.next().charAt(0));
        }

        translateCommand(lunarCraft, commands);
        System.out.println("Final position is: (" + lunarCraft.x + ", " + lunarCraft.y + ", " + lunarCraft.z + ")");
        System.out.println("Final Direction is: " + lunarCraft.direction);
    }
    
    public static boolean isValidDirection(char dir)
    {
    	if(dir == 'N' || dir == 'S' || dir == 'W' || dir == 'E' || dir == 'U' || dir == 'D')
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean isValidCommand(char command)
    {
    	ArrayList<Character> commands = new ArrayList<Character>(6);
    	
    	commands.add('f');
    	commands.add('b');
    	commands.add('l');
    	commands.add('r');
    	commands.add('u');
    	commands.add('d');
    	return commands.contains(command);
    }
}

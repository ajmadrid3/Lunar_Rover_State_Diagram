/*
 * Andrew Madrid
 * CS 3331 - Advanced Object-Oriented Programming
 * Assignment 4 - UML State Machine
 * Fall 2017
 * Purpose:
 * 	This program is used to replicate the state machine for the Lunar Rover.
 * 	It contains all of the states the machine can be in, as well as the acitons
 *  that can be performed and the jumps from one state to another.
 */
import java.util.Scanner;
public class Lunar_Rover 
{
	// ENUM Motion_State holds all of the states that are listed in the State Diagram
	public enum Motion_State {
		IDLE, MOVE_FORWARD_ACCELERATE, MOVE_FORWARD_CONSTANT, DECELERATE, MOVE_BACKWARD_ACCELERATE, MOVE_BACKWARD_CONSTANT
	}
	
	// Based on the user input, the state will either change to a certain state or
	// remain in the same one.  Tells the user what action is being performed.
	public static Motion_State change_State(Motion_State current, int choice)
	{
		switch(current) {
			case IDLE:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				} else if(choice == 3) {
					System.out.println("Holding Right Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else if(choice == 5) {
					System.out.println("Holding Left Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_BACKWARD_ACCELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.IDLE;
				}
				break;
			case MOVE_FORWARD_ACCELERATE:
				if(choice == 2) {
					System.out.println("Pressing Right Pedal Twice");
					current = Motion_State.DECELERATE;
				} else if(choice == 3) {
					System.out.println("Holding Right Pedal Down for 6 Seconds.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else if(choice == 4) {
					System.out.println("Pressing Left Pedal Once.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				}
				break;
			case MOVE_FORWARD_CONSTANT:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.MOVE_FORWARD_ACCELERATE;
				} else if(choice == 2) {
					System.out.println("Pressing Right Pedal Twice.");
					current = Motion_State.DECELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_FORWARD_CONSTANT;
				}
				break;
			case DECELERATE:
				if(choice == 6) {
					System.out.println("Slowing Down to Speed 0.");
					current = Motion_State.IDLE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.DECELERATE;
				}
				break;
			case MOVE_BACKWARD_ACCELERATE:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.DECELERATE;
				} else if(choice == 4) {
					System.out.println("Pressing Left Pedal Once.");
					current = Motion_State.MOVE_BACKWARD_CONSTANT;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_BACKWARD_ACCELERATE;
				}
				break;
			case MOVE_BACKWARD_CONSTANT:
				if(choice == 1) {
					System.out.println("Pressing Right Pedal Once.");
					current = Motion_State.DECELERATE;
				} else {
					System.out.println("Nothing Happened.");
					current = Motion_State.MOVE_BACKWARD_CONSTANT;
				}
			default:
				System.out.println();
		}
		return current;
	}
	
	// Prints the current state that the user is in
	public static void print_State(Motion_State current)
	{
		System.out.println("You are currently in the " + current + " state.\n");
	}
	
	public static void main(String args[])
	{
		Motion_State current_State = Motion_State.IDLE;
		Scanner scnr = new Scanner(System.in);
		int action = 0;
		System.out.println("Welcome to the Lunar Rover\n");
		print_State(current_State);
		while(action != 7)
		{
			System.out.println("What would you like to do?\n");
			System.out.println("1: Press Right Pedal Once");
			System.out.println("2: Press Right Pedal Twice");
			System.out.println("3: Hold Right Pedal Down for 6 Seconds");
			System.out.println("4: Press Left Pedal Once");
			System.out.println("5: Hold Left Pedal Down for 6 Seconds");
			System.out.println("6: Let Speed Reach 0");
			System.out.println("7: Exit Program\n");
			
			System.out.print("Action: ");
			
			action = scnr.nextInt();
			if(action == 7) 
			{
				break;
			}
			else if(action < 1 || action > 7)
			{
				System.out.println("ERROR: Incorrect value entered.\n");
			}
			else
			{
				System.out.println("Performing action.");
				current_State = change_State(current_State, action);
				print_State(current_State);
			}
		}
		System.out.println("Exiting Program");
	}
}

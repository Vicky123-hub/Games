package Games;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Gamers {
	static Scanner sc=new Scanner(System.in);
	private static int position = 0;
	private static String fileName="questionAndAnswer.txt";
	private static List<String[]> question=new ArrayList<>();
	private static int score = 0;
	private static String highScore="score.txt";
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter 1 for Rock Paper Scicsor game.");
			System.out.println("Enter 2 for Snake and ladder.");
			System.out.println("Enter 3 for quizGame.");
			System.out.println("enter 4 for exit.");
			int x=0;
			while(true) {
			try {
				String input=sc.next();
				x=Integer.parseInt(input);
				if(x<1 || x>4) {
					System.out.println("Enter 1 for Rock Paper Scicsor game.");
					System.out.println("Enter 2 for Snake and ladder.");
					System.out.println("Enter 3 for quizGame.");
					System.out.println("enter 4 for exit.");
					continue;
				}
				break;
			}catch(NumberFormatException e) {
				System.out.println("Enter number only.");
			}
			}
			switch(x) {
			case 1 -> RockPaperScicsor();
			case 2 -> snakeandladder();
			case 3 -> quizGame();
			case 4 -> System.exit(0);
			}
			
		}
	}
	private static void RockPaperScicsor() {
	    System.out.println("Welcome to Rock Paper Scissor game.");
	    String command[] = {"Rock", "Paper", "Scissor"};
	    while (true) {
	        System.out.println("Do you want to play yes/no");
	        System.out.println("--------------------------");
	        String input = sc.nextLine();
	        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
	            if (input.equalsIgnoreCase("no")) {
	                System.out.println("-----------------------------------");
	                System.out.println("Exiting the Rock Paper Scissor game.");
	                System.out.println("------------------------------------");
	                break;
	            }
	            System.out.println("-------------------");
	            System.out.println("Enter 1 for Rock\nEnter 2 for Paper\nEnter 3 for Scissor");
	            System.out.println("--------------------");
	            int userChoice = sc.nextInt();
	            sc.nextLine();
	            int compChoice = (int)(Math.random() * 3); // 0,1,2

	            if ((userChoice - 1 == (compChoice + 1) % 3)) {
	                System.out.println("-----------------------------------------------------------------------");
	                System.out.println("Congratulations! Your choice " + command[userChoice - 1] +
	                                   " and computer choice is " + command[compChoice] + ". You won.");
	                System.out.println("-----------------------------------------------------------------------");
	            } else if (userChoice - 1 == compChoice) {
	                System.out.println("----------------------------------------------------------");
	                System.out.println("Your choice " + command[userChoice - 1] +
	                                   " and computer choice is " + command[compChoice] + ". It's a draw.");
	                System.out.println("----------------------------------------------------------");
	            } else {
	                System.out.println("---------------------------------------------------------------------------------------------------------");
	                System.out.println("Oops! Your choice " + command[userChoice - 1] +
	                                   " and computer choice is " + command[compChoice] + ". You lose.");
	                System.out.println("---------------------------------------------------------------------------------------------------------");
	            }
	        } else {
	            System.out.println("---------------------------");
	            System.out.println("Please input only yes or no");
	            System.out.println("---------------------------");
	        }
	    }
	}

	public static void printDiceFace(int dice) {
        switch (dice) {
            case 1 -> System.out.println(" ----- \n|     |\n|  *  |\n|     |\n -----\n");
            case 2 -> System.out.println(" ----- \n|*    |\n|     |\n|    *|\n -----\n");
            case 3 -> System.out.println(" ----- \n|*    |\n|  *  |\n|    *|\n -----\n");
            case 4 -> System.out.println(" ----- \n|*   *|\n|     |\n|*   *|\n -----\n");
            case 5 -> System.out.println(" ----- \n|*   *|\n|  *  |\n|*   *|\n -----\n");
            case 6 -> System.out.println(" ----- \n|*   *|\n|*   *|\n|*   *|\n -----\n");
        }
    }
	private static void snakeandladder() {
        boolean hasStarted = false;

        while (true) {
            System.out.println("Enter * to roll the dice:");
            String input = sc.next();

            int dice = (int) (Math.random() * 6 + 1);
            System.out.println("You rolled: " + dice);
            printDiceFace(dice);

            if (!hasStarted) {
                if (dice == 6) {
                    hasStarted = true;
                    position = 6;
                    System.out.println(" You rolled 6! Game started. Your position: " + position);
                } else {
                    System.out.println("You need a 6 to start. Try again.\n");
                }
            } else {
                if (position + dice > 100) {
                    System.out.println("You need exact roll to reach 100. Stay at: " + position);
                } else {
                    int prev = position;
                    position += dice;
                    System.out.println("You moved to: " + position);

                    int beforeLadder = position;
                    switch (position) {
                    case 7: position = 14; break;
                    case 13: position = 25; break;
                    case 21: position = 42; break;
                    case 36: position = 58; break;
                    case 44: position = 65; break;
                    case 47: position = 67; break;
                    case 61: position = 78; break;
                    case 64: position = 82; break;
                    case 66: position = 88; break;
                }
                    
                    if (position != beforeLadder) {
                        System.out.println(" You climbed a ladder to: " + position);
                    }

                    int beforeSnake = position;
                    switch (position) {
                    case 46: position = 31; break;
                    case 52: position = 38; break;
                    case 60: position = 45; break;
                    case 65: position = 50; break;
                    case 87: position = 70; break;
                    case 90: position = 72; break;
                    case 93: position = 75; break;
                    case 99: position = 80; break;
                }
                    if (position != beforeSnake) {
                        System.out.println(" Oh no! Bitten by a snake, moved to: " + position);
                    }
                }
            }

            for (int row = 10; row >= 1; row--) {
                for (int col = 1; col <= 10; col++) {
                    int pos;
                    if (row % 2 == 0) {
                        pos = (row - 1) * 10 + col;
                    } else {
                        pos = row * 10 - (col - 1);
                    }
                    if (pos == position) {
                        System.out.printf("|%3s", "P");
                    } else {
                        System.out.printf("|%3d", pos);
                    }
                }
                System.out.println("|");
            }

            if (position == 100) {
                System.out.println("\n Congratulations! You reached 100 and won the game!");
                break;
            }
        }
        System.out.println("Thanks for playing!");
        sc.close();
	}
	private static void quizGame() {
		try(BufferedReader br=new BufferedReader(new FileReader(highScore))){
			score=br.read();
		}catch(IOException e) {
			System.out.println("Error "+e.getMessage());
		}
		try (BufferedReader br=new BufferedReader(new FileReader(fileName));){
			String line;
			boolean firstline=true;
			while((line=br.readLine())!=null) {
				if(firstline) {
					firstline=false;
					continue;
				}
				String part[]=line.split(",");
				if(part.length==6) {
					question.add(part);
				}
			}
	}catch(IOException e){
		System.out.println("Error reading file: " + e.getMessage());
	}
		for(int i=0;i<10 && i<question.size();i++) {
			String getQ[]=question.get(i);
			System.out.println("Q.NO "+(i+1)+getQ[0]);
			System.out.println("Option 1 : "+getQ[1]);
			System.out.println("Option 2 : "+getQ[2]);
			System.out.println("Option 3 : "+getQ[3]);
			System.out.println("Option 4 : "+getQ[4]);
			System.out.println("Your answer : (1 or 2 or 3 or 4)");
			int num=0;
			while(true) {
				String input=sc.nextLine();
			try {
	             num =Integer.parseInt(input);  
	             if(num<1 || num>4) {
	            	 System.out.println("Enter correct option (1 , 2 , 3 , 4)");
	            	 continue;
	             }
	            System.out.println("You entered number: " + num);
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input! Please enter only numbers.");
	        }
			}
			if(num== Integer.parseInt(getQ[5])) {
				score++;
				System.out.println("Correct. Your highestScore is "+score);
				try(BufferedWriter br=new BufferedWriter(new FileWriter(highScore))){
					br.write(String.valueOf(score));
        		}catch(IOException e) {
        			System.out.println("Error "+e.getMessage());
        			return;
        		}
			}else {
	                System.out.println(" Wrong! Correct answer: " + getQ[Integer.parseInt(getQ[5])]);
	                
			}
		}
	}
}
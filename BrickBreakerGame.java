import java.util.Scanner;

public class BrickBreakerGame {
    public static void main(String[] args) {
        int rows = 5; 
        int cols = 10; 
        int paddlePosition = cols / 2; 
        int ballPositionX = rows - 2; 
        int ballPositionY = cols / 2;
        int ballDirectionX = -1; 
        int ballDirectionY = -1;

        int[][] bricks = new int[rows][cols]; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                bricks[i][j] = 1;
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i == ballPositionX && j == ballPositionY) {
                        System.out.print("O"); 
                    } else if (i == rows - 1 && j == paddlePosition) {
                        System.out.print("="); 
                    } else if (bricks[i][j] == 1) {
                        System.out.print("#"); 
                    } else {
                        System.out.print(" "); 
                    }
                }
                System.out.println();
            }

            
            ballPositionX += ballDirectionX;
            ballPositionY += ballDirectionY;

            
            if (ballPositionX == 0 || bricks[ballPositionX][ballPositionY] == 0) {
                ballDirectionX = -ballDirectionX;
            }
            if (ballPositionY == 0 || ballPositionY == cols - 1) {
                ballDirectionY = -ballDirectionY;
            }

            
            if (ballPositionX == rows - 1 && ballPositionY == paddlePosition) {
                ballDirectionX = -ballDirectionX;
            }

        
            if (ballPositionX == rows - 1 && bricks[ballPositionX][ballPositionY] == 1) {
                System.out.println("Game Over!");
                break;
            }

            
            System.out.print("Move the paddle (A: Left, D: Right): ");
            char move = scanner.next().charAt(0);
            if (move == 'A' || move == 'a') {
                if (paddlePosition > 0) {
                    paddlePosition--;
                }
            } else if (move == 'D' || move == 'd') {
                if (paddlePosition < cols - 1) {
                    paddlePosition++;
                }
            }

            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        scanner.close();
    }
}

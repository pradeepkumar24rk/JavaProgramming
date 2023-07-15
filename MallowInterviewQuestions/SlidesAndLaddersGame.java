import java.util.Scanner;

public class SlidesAndLaddersGame {

    public static int check(int[] player_positions, int new_position, int num_players) {
        int c = -1;
        for (int i = 0; i < num_players; i++) {
            if (player_positions[i] == new_position) {
                c = i;
                break;
            }
        }
        return c;
    }

    public static void playSlidesAndLadders(int num_players, String[] player_names, String starting_player,
                                            int dice_count, int[] dice_values) {
        // Initialize player positions and game variables
        int[] player_positions = new int[num_players];
        int[] laddersused = new int[num_players];
        int[] slidesused = new int[num_players];
        int[] start = new int[num_players];
        for (int i = 0; i < num_players; i++) {
            player_positions[i] = 0;
            laddersused[i] = 0;
            slidesused[i] = 0;
            start[i] = 0;
        }
        int[] slides = { 21, 24, 14 };
        int[] slides_dest = { 2, 16, 5 };
        int[] ladders = { 4, 6, 18 };
        int[] ladders_dest = { 12, 15, 23 };
        int starting_player_index = -1;
        for (int i = 0; i < num_players; i++) {
            if (player_names[i].equals(starting_player)) {
                starting_player_index = i;
                break;
            }
        }
        if (starting_player_index == -1) {
            System.out.println("Starting player not found.");
            return;
        }
        int current_player_index = starting_player_index;
        int remaining_count = dice_count;
        while (remaining_count > 0) {
            String current_player = player_names[current_player_index];
            int current_position = player_positions[current_player_index];
            int dice_value = dice_values[dice_count - remaining_count];
            remaining_count--;
            if (start[current_player_index] == 0) {
                if (dice_value == 1) {
                    start[current_player_index] = 1;
                } else {
                    if (current_player_index == num_players - 1)
                        current_player_index = 0;
                    else
                        current_player_index++;
                    continue;
                }
            }
            int new_position = current_position + dice_value;
            for (int i = 0; i < 3; i++) {
                if (new_position == slides[i]) {
                    new_position = slides_dest[i];
                    slidesused[current_player_index]++;
                    break;
                } else if (new_position == ladders[i]) {
                    new_position = ladders_dest[i];
                    laddersused[current_player_index]++;
                    break;
                }
            }
            int c = check(player_positions, new_position, num_players);
            if (c != -1)
                player_positions[c] = 1;
            if (new_position > 25)
                continue;
            else if (new_position < 25)
                player_positions[current_player_index] = new_position;
            else if (new_position == 25) {
                player_positions[current_player_index] = new_position;
                break;
            }

            if (dice_value == 1 || dice_value == 5)
                continue;
            else if (current_player_index == num_players - 1)
                current_player_index = 0;
            else
                current_player_index++;
        }
        for (int i = 0; i < num_players; i++) {
            int remaining = 25 - player_positions[i];
            System.out.printf("%s|%d|%d|%d|%d\n", player_names[i], player_positions[i], remaining, slidesused[i],
                    laddersused[i]);
        }
        for (int i = 0; i < num_players; i++) {
            if (player_positions[i] != 25) {
                System.out.printf("%s,", player_names[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num_players = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String[] player_names = new String[num_players];
        for (int i = 0; i < num_players; i++) {
            player_names[i] = scanner.nextLine();
        }
        String starting_player = scanner.nextLine();
        int dice_count = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        int[] dice_values = new int[dice_count];
        for (int i = 0; i < dice_count; i++) {
            dice_values[i] = scanner.nextInt();
        }

        playSlidesAndLadders(num_players, player_names, starting_player, dice_count, dice_values);

        scanner.close();
    }
}
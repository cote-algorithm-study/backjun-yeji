import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] current = br.readLine().split(":");
        String[] target = br.readLine().split(":");

        int currentSeconds = Integer.parseInt(current[2]);
        int targetSeconds = Integer.parseInt(target[2]);
        int resultSeconds;
        int plusSeconds = 0;
        if(currentSeconds > targetSeconds){
            resultSeconds = (60- currentSeconds) + targetSeconds;
            plusSeconds++;
        }else{
            resultSeconds = targetSeconds - currentSeconds;
        }

        int currentMinutes = Integer.parseInt(current[1]);
        int targetMinutes = Integer.parseInt(target[1])-plusSeconds;
        int resultMinutes;
        int plusMinutes = 0;
        if(currentMinutes > targetMinutes) {
            resultMinutes = (60 - currentMinutes) + targetMinutes;
            plusMinutes++;
        }else{
            resultMinutes = targetMinutes - currentMinutes;
        }

        int currentHours = Integer.parseInt(current[0]);
        int targetHours = Integer.parseInt(target[0])-plusMinutes;

        int resultHours;
        if(currentHours > targetHours){
            resultHours = (24 - currentHours) + targetHours;
        }else if(currentHours == targetHours){
            resultHours = 24;
        }else{
            resultHours = targetHours - currentHours;
        }

        System.out.println(String.format("%02d:%02d:%02d", resultHours, resultMinutes, resultSeconds));
    }
}
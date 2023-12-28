import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) throws Exception {
        int answer = 0;
        LinkedList<String> cars = new LinkedList<>();
        Map<String, Integer> enterMap = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            cars.add(car);
            enterMap.put(car, i);
        }

        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            int order = cars.indexOf(car);

            //추월함
            if (order > i) {
                cars.remove(car);
                cars.add(i, car);
                answer++;
            }
        }


        System.out.println(answer);
    }
}


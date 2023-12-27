import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {

        Map<String, Integer> carIn = new HashMap<>();
        Map<String, Integer> parkingInfo = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (String record : records) {
            String[] info = record.split(" ");
            String[] time = info[0].split(":");

            int recordTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (info[2].equals("IN")) {
                carIn.put(info[1], recordTime);
            }

            if (info[2].equals("OUT")) {
                int carInTime = carIn.get(info[1]);
                int totalTime = recordTime - carInTime;

                int parkingTime = parkingInfo.getOrDefault(info[1], 0);
                parkingTime += totalTime;
                parkingInfo.put(info[1], parkingTime);

                carIn.remove(info[1]);
            }
        }

        Set<String> keys = carIn.keySet();

        for (String key : keys) {
            int recordTime = carIn.get(key);
            int total = ((23 * 60) + 59) - recordTime;

            int parkingTime = parkingInfo.getOrDefault(key, 0);
            parkingTime += total;
            parkingInfo.put(key, parkingTime);
        }

        List<String> carList = new ArrayList<>(parkingInfo.keySet());
        Collections.sort(carList);

        for (String car : carList) {
            if (parkingInfo.get(car)  <= fees[0]) {
                answer.add(fees[1]);
            } else {
                int overTime = (parkingInfo.get(car) - fees[0]);
                int overPrice = (int)Math.ceil((double) overTime / fees[2]) * fees[3] + fees[1];


                answer.add(overPrice);
            }
        }

        return answer;
    }
}
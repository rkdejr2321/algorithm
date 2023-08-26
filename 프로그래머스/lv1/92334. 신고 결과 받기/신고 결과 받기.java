import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashSet<String> reportSet = new HashSet<String>(Arrays.asList(report));
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> mail = new HashMap<>();
        
        for (String reportValue : reportSet) {
            String[] reportParts = reportValue.split(" ");
            String reported = reportParts[1];
            
            int reportCount = map.getOrDefault(reported, 0);
            map.put(reported, reportCount + 1);
        }
        
        Iterator<String> iter = reportSet.iterator(); 
            
        while (iter.hasNext()) {
            String[] reportParts = iter.next().split(" ");
            String sender = reportParts[0];
            String reported = reportParts[1];
            
                
            int mailCount = mail.getOrDefault(sender, 0);
            if (map.get(reported) >= k) {
                mailCount += 1;
            }
            mail.put(sender, mailCount);            
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }
        

        return answer;
    }
}

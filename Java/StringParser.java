import java.util.HashMap;
import java.util.Map;

public class StringParser {

//    解析json
//    {K:V,K:{K:V}}
    public static HashMap<String, Object> parseJson(String input){
        HashMap<String, Object> res = new HashMap<>();
        if (input == null) {
            return res;
        }

        if (input.startsWith("{") && input.endsWith("}")){
            input = input.substring(1, input.length()-1).trim();
            String[] entries = input.split(",");
            for (String entry :
                    entries) {
                String[] KV = entry.trim().split(":");
                if (KV[1].startsWith("{") && KV[1].endsWith("}")){
                    res.put(KV[0], parseJson(KV[1]));
                }else {
                    res.put(KV[0], KV[1]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String jsonStr = "{name:John, age:{K:V}, city:New York}";
        HashMap<String, Object> result = parseJson(jsonStr);

        System.out.println("Parsed JSON: " + result);
    }

}

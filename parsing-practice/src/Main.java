import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    private static String Address; //주소를 저장할 String값
    private static URL url;//주소와 같이 연결해줄때 사용
    private static BufferedReader br;//결과값을 받아와서 출력
    private static HttpURLConnection conn;//URL을 가지고 실제로 연결을 수행하는 중추적인 역할
    private static String protocol = "GET";//웹에서 명령수행을 할때 요청과 응답 방식을 저장

    public static void main(String[] args) throws Exception {
        Address = "http://www.law.go.kr/DRF/lawSearch.do?OC=hh7769&target=law&type=XML&query=%ED%97%8C%EB%B2%95";

        url = new URL(Address);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(protocol);

        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

    }
}
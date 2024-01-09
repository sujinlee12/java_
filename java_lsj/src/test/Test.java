import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // 포트 번호 12345로 서버 소켓 생성
        System.out.println("서버가 시작되었습니다.");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 대기
            System.out.println("클라이언트가 접속했습니다.");

            // 클라이언트와 통신을 위한 입력 및 출력 스트림 생성
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            // 클라이언트로부터 메시지 수신 및 응답
            String clientMessage = reader.readLine();
            System.out.println("클라이언트 메시지: " + clientMessage);
            String response = "서버에서 응답: " + clientMessage;
            writer.println(response);

            // 연결 종료
            clientSocket.close();
        }
    }
}
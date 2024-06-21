import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import javazoom.jl.player.MP3Player;

public class View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player();
		DAO dao = new DAO();
		DTO dto = new DTO();
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int C = 0;
		int E = 0;
		int I = 0;
		int S = 0;
		int N = 0;
		int T = 0;
		int F = 0;
		int J = 0;
		int P = 0;
		String id = null;
		String pw = null;
		String EI = null;
		String SN = null;
		String FT = null;
		String PJ = null;
		String MBTI1 = null;
		Boolean login = false;
		int check = 0;
		int row = 0;
		ArrayList<ArrayListConstructor> Q = new ArrayList<ArrayListConstructor>();
		ArrayList<ArrayListConstructor> A = new ArrayList<ArrayListConstructor>();
		ArrayList<DTO> musicList = new ArrayList<DTO>();
		String comPath = "C:\\Users\\smhrd\\OneDrive\\바탕 화면\\MBTI\\music\\";
		
		mp3.play(comPath+"전체 브금음악.mp3");
		System.out.println(
			     "\t  .----------------.  .----------------.  .----------------.  .----------------. \n" +
			     "\t | .--------------. || .--------------. || .--------------. || .--------------. |\n" +
			     "\t | | ____    ____ | || |   ______     | || |  _________   | || |     _____    | |\n" +
			     "\t | ||_   \\  /   _|| || |  |_   _ \\    | || | |  _   _  |  | || |    |_   _|   | |\n" +
			     "\t | |  |   \\/   |  | || |    | |_) |   | || | |_/ | | \\_|  | || |      | |     | |\n" +
			     "\t | |  | |\\  /| |  | || |    |  __'.   | || |     | |      | || |      | |     | |\n" +
			     "\t | | _| |_\\/_| |_ | || |   _| |__) |  | || |    _| |_     | || |     _| |_    | |\n" +
			     "\t | ||_____||_____|| || |  |_______/   | || |   |_____|    | || |    |_____|   | |\n" +
			     "\t | |              | || |              | || |              | || |              | |\n" +
			     "\t | '--------------' || '--------------' || '--------------' || '--------------' |\n" +
			     "\t  '----------------'  '----------------'  '----------------'  '----------------' \n" +
			     "\t  .----------------.  .----------------.  .----------------.  .----------------. \n" +
			     "\t | .--------------. || .--------------. || .--------------. || .--------------. |\n" +
			     "\t | |  _________   | || |  _________   | || |    _______   | || |  _________   | |\n" +
			     "\t | | |  _   _  |  | || | |_   ___  |  | || |   /  ___  |  | || | |  _   _  |  | |\n" +
			     "\t | | |_/ | | \\_|  | || |   | |_  \\_|  | || |  |  (__ \\_|  | || | |_/ | | \\_|  | |\n" +
			     "\t | |     | |      | || |   |  _|  _   | || |   '.___`-.   | || |     | |      | |\n" +
			     "\t | |    _| |_     | || |  _| |___/ |  | || |  |`\\____) |  | || |    _| |_     | |\n" +
			     "\t | |   |_____|    | || | |_________|  | || |  |_______.'  | || |   |_____|    | |\n" +
			     "\t | |              | || |              | || |              | || |              | |\n" +
			     "\t | '--------------' || '--------------' || '--------------' || '--------------' |\n" +
			     "\t  '----------------'  '----------------'  '----------------'  '----------------' " );
		System.out.println();
		while(true) {
	while(true)	{System.out.println("\t\t 1. 로그인 \t\t2.회원가입");
		
		System.out.print("\t 번호를 선택해주세요 >> ");
		int SelectMenu = sc.nextInt();

		////////////////////////////////////////
		if (SelectMenu == 1) {
			System.out.println("\t [로그인]");
			System.out.print("\t ID >> : ");
			id = sc.next();
			System.out.print("\t PW >> : ");
			pw = sc.next();

			dto = dao.login(id, pw);
			if(dto != null) {
				System.out.println();
				System.out.println("\t 로그인 성공!");
				break;
			}else {
				System.out.println("아이디와 비밀번호를 확인하세요");
			}
			
		} else if (SelectMenu == 2) {
			System.out.print("\t ID를 입력해주세요 : ");
			id = sc.next();
			System.out.print("\t PW를 입력해주세요 : ");
			pw = sc.next();
			System.out.print("\t 이름을 입력해주세요 : ");
			String name = sc.next();
			DTO dtojoin = new DTO(null, id, pw, name);
			row = dao.join(dtojoin);

			if (row > 0) {
				System.out.println("\t 회원가입 완료");
				break;
			} else {
				System.out.println("\t 회원가입 실패");
			}

		} else {
			System.out.println("\t 번호를 확인해주세요");
		}
		}
		while (true) {
			if (dto != null) {
				System.out.println("\t ____    __    ____  _______  __        ______   ______   .___  ___.  _______ \n" +
                        "\t \\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|\n" +
                        "\t  \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__   \n" +
                        "\t   \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|  \n" +
                        "\t    \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____ \n" +
                        "\t     \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|");
 
				System.out.println();
				try {
					Thread.sleep(2000);
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				login = true;
				break;
			} else {
				System.out.println("\t 로그인에 실패했습니다.");
				System.out.println("\t 아이디와 비밀번호를 확인해주세요");
				break;

			}}
		if (login = true) {
			break;
		}
		}
		/////////////////////////////////////////////
		while (true) {
			if (dto == null) {
				break;
			}
			
			dao.pick();
			System.out.println();
			System.out.println("\t\t\t [\t테마를 골라주세요\t    ]");
			System.out.print("\t\t [1]연애\t\t [2]학원\t\t [3]회사\t\t>> ");
			int SelectTema = sc.nextInt();
			mp3.stop();
			
			if (login == true && SelectTema == 1) {
				mp3.stop();	
				mp3.play(comPath+"연애테마.mp3");
				try {
					System.out.print(" \t  __        ______   ____    ____  _______   .@@.@@   \n" +
				            "\t |  |      /  __  \\  \\   \\  /   / |   ____|  @@@@@@@-\n" +
				            "\t |  |     |  |  |  |  \\   \\/   /  |  |__      @@@@@   \n" +
				            "\t |  `----.|  `--'  |   \\      /   |  |____     @@@    \n" +
				            "\t |_______| \\______/     \\____/    |_______|    -@ ");
					System.out.println();
					System.out.println("\t [연애편]");

					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_3";
					String user = "cgi_23K_BIG23_p1_3";
					String passward = "smhrd3";
					conn = DriverManager.getConnection(url, user, passward);

					String sql = "select Q1, T1Result1, T1Result2 from tema1";

					psmt = conn.prepareStatement(sql);

					rs = psmt.executeQuery();

					while (rs.next()) {
						String Q1 = rs.getString("Q1");
						String A1 = rs.getString("T1Result1");
						String A2 = rs.getString("T1Result2");
						Q.add(new ArrayListConstructor(Q1));
						A.add(new ArrayListConstructor(A1, A2));
					}

					//////////////////////////////////////////////////
					System.out.println("\t 친구에게 소개팅을 받기로 했다. 주선자에게 상대방에 대해 물어보려고 한다.");
					System.out.println("\t "+Q.get(0).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(0).A1 + "\t" + "2. " + A.get(0).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if(C == 2){
						N++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
						
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 며칠 후 소개팅 날짜가 다가왔다.");
					System.out.println("\t "+Q.get(1).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(1).A1 + "\t" + "2. " + A.get(1).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C == 2){
						J++; break;
					}else {
							System.out.println("\t !!번호를 다시 입력해주세요!!");
						}
					}
					//////////////////////////////////////////////////////////
					System.out.println("\t 밖에서 소개팅 상대방을 기다리는 중이다. ");
					System.out.println("\t "+Q.get(2).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(2).A1 + "\t" + "2. " + A.get(2).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if (C == 2) {
						I++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 소개팅 상대방이 이제 밥을 먹으러 가자고 한다");
					System.out.println("\t "+Q.get(3).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(3).A1 + "\t" + "2. " + A.get(3).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if (C == 2){
						J++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 밥을 먹고 있는 도중 소개팅 상대방이 말한다.");
					System.out.println("\t "+Q.get(4).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(4).A1 + "\t" + "2. " + A.get(4).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if (C == 2){
						T++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 즐거운 식사 시간이 끝나고 서로 이제 집에 가려고 한다.");
					System.out.println("\t "+Q.get(5).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(5).A1 + "\t" + "2. " + A.get(5).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if (C == 2){
						T++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 슬슬 서로의 마음이 드러나고 소개팅 상대방이 아주 마음에 든다.");
					System.out.println("\t "+Q.get(6).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(6).A1 + "\t" + "2. " + A.get(6).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if (C ==2){
						N++; break;
					}else {
						System.out.println("!!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 드디어 커플이 된 후 첫 데이트 날이 다가왔다.");
					System.out.println("\t "+Q.get(7).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(7).A1 + "\t" + "2. " + A.get(7).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if (C == 2) {
						I++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 데이트를 한 후 처음 개봉한 영화가 있어서 보러 가려고 한다.");
					System.out.println("\t "+Q.get(8).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(8).A1 + "\t" + "2. " + A.get(8).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if (C == 2){
						N++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 연인이 여행을 가자고 한다.");
					System.out.println("\t "+Q.get(9).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(9).A1 + "\t" + "2. " + A.get(9).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if (C == 2){
						J++; break;
					} else {
					System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 즐거운 여행이 끝나가고 이제 술을 먹으려고 한다.");
					System.out.println("\t "+Q.get(10).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(10).A1 + "\t" + "2. " + A.get(10).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if (C == 2){
						I++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 숙소로 와서 연인이 자연스럽게 물어본다.");
					System.out.println("\t "+Q.get(11).Q);
				 	while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(11).A1 + "\t" + "2. " + A.get(11).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if (C== 2){
						T++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					if (E > I) {
						EI = "E";
					} else {
						EI = "I";
					}
					if (S > N) {
						SN = "S";
					} else {
						SN = "N";
					}
					if (F > T) {
						FT = "F";
					} else {
						FT = "T";
					}
					if (P > J) {
						PJ = "P";
					} else {
						PJ = "J";
					}
					MBTI1 = EI + SN + FT + PJ;
					System.out.println(
							 "\t  __        ______        ___       _______   __   __   __    _______             \n" +
			                "\t |  |      /  __  \\      /   \\     |       \\ |  | |  \\ |  |  /  _____|            \n" +
			                "\t |  |     |  |  |  |    /  ^  \\    |  .--.  ||  | |   \\|  | |  |  __              \n" +
			                "\t |  |     |  |  |  |   /  /_\\  \\   |  |  |  ||  | |    `  | |  | |_ |             \n" +
			                "\t |  `----.|  `--'  |  /  _____  \\  |  '--'  ||  | |  |\\   | |  |__| |  __  __  __ \n" +
			                "\t |_______| \\______/  /__/     \\__\\ |_______/ |__| |__| \\__|  \\______| (__)(__)(__)");

					Thread.sleep(3000);
					System.out.println();
					System.out.println("\t 당신의 연애테마 MBTI는!!!!");
					Thread.sleep(1000);
//				System.out.println(MBTI1 + "입니다!");
					dao.MBTI1(MBTI1);
					Q.clear();
					A.clear();
					mp3.stop();
					mp3.play(comPath+"전체 브금음악.mp3");
					dto = new DTO(MBTI1, id, pw);
					row = dao.update1(dto);
					if (row > 0) {
						System.out.println("\t MBTI 업데이트 완료");
					} else {
						System.out.println("\t MBTI 업데이트 실패");

					}
					while (true) {
						System.out.println("\t 다른 테마를 플레이하시겠습니까?");
						System.out.print("\t 1. 네 \t 2. 아니요 \t >> ");
						check = sc.nextInt();
						if (check == 1) {
							break;
						} else if (check == 2) {
							break;
						} else {
							System.out.println("\t 번호를 확인해주세요");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (check == 2) {
					break;
				}
			} else if (login == true && SelectTema == 2) {
				/////////////////////////////////////////////////////// 테마 2번

				try {
					mp3.stop();
					mp3.play(comPath+"학원 테마.mp3");
					   System.out.println("\t      _______..___  ___.  __    __  .______       _______  ");
			           System.out.println("\t     /       ||   \\/   | |  |  |  | |   _  \\     |       \\ ");
			           System.out.println("\t    |   (----`|  \\  /  | |  |__|  | |  |_)  |    |  .--.  |");
			           System.out.println("\t     \\   \\    |  |\\/|  | |   __   | |      /     |  |  |  |");
			           System.out.println("\t .----)   |   |  |  |  | |  |  |  | |  |\\  \\----.|  '--'  |");
			           System.out.println("\t |_______/    |__|  |__| |__|  |__| | _| `._____||_______/ ");

			           System.out.println("\t [학원편]");

					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_3";
					String user = "cgi_23K_BIG23_p1_3";
					String passward = "smhrd3";
					conn = DriverManager.getConnection(url, user, passward);

					String sql = "select Q2, T2Result1, T2Result2 from tema2";

					psmt = conn.prepareStatement(sql);

					rs = psmt.executeQuery();

					while (rs.next()) {
						String Q1 = rs.getString("Q2");
						String A1 = rs.getString("T2Result1");
						String A2 = rs.getString("T2Result2");
						Q.add(new ArrayListConstructor(Q1));
						A.add(new ArrayListConstructor(A1, A2));
					}

					//////////////////////////////////////////////////
					System.out.println("\t 드디어 스마트인재개발원 빅데이터 분석 서비스 개발자 과정이 내일 개강을 한다.");
					System.out.println("\t "+Q.get(0).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(0).A1 + "\t" + "2. " + A.get(0).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C == 2) {
						J++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 드디어 개강날이 되었다.");
					System.out.println("\t "+Q.get(1).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(1).A1 + "\t" + "2. " + A.get(1).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if(C ==2 ){
						I++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 자기소개 시간이 다가와서 앞에 나가서 나를 소개해야 한다.");
					System.out.println("\t "+Q.get(2).Q);
					while(true){   
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(2).A1 + "\t" + "2. " + A.get(2).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if (C ==2 ){
						I++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 오후 수업 시간 선생님께서 열심히 하면 들어본 좋은 기업에 취업할 수 있다고 말씀하고 계신다.");
					System.out.println("\t "+Q.get(3).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(3).A1 + "\t" + "2. " + A.get(3).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if (C==2) {
						N++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 한 달 동안 지내야 할 팀을 정하고 있다.");
					System.out.println("\t "+Q.get(4).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(4).A1 + "\t" + "2. " + A.get(4).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if (C==2){
						N++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 팀이 정해졌고 팀장을 뽑으려고 하고 있다.");
					System.out.println("\t "+Q.get(5).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(5).A1 + "\t" + "2. " + A.get(5).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if (C == 2) {
						I++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!"); 
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 팀플 주제를 회의하고 있다.");
					System.out.println("\t "+Q.get(6).Q);
					while(true){   
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(6).A1 + "\t" + "2. " + A.get(6).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if(C == 2) {
						N++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 회의 중 여러 가지 의견이 오가고 있다.");
					System.out.println("\t "+Q.get(7).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(7).A1 + "\t" + "2. " + A.get(7).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if (C==2) {
						T++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 팀플 역할을 분담으로 사다리타기를 하고 있다.");
					System.out.println("\t "+Q.get(8).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(8).A1 + "\t" + "2. " + A.get(8).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if (C==2) {
						J++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 발표가 끝난 후 선생님께 칭찬을 받았다.");
					System.out.println("\t "+Q.get(9).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(9).A1 + "\t" + "2. " + A.get(9).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if(C==2) {
						T++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 팀플이 끝난 후 회식을 가기로 했다.");
					System.out.println("\t "+Q.get(10).Q);
					while(true){   
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(10).A1 + "\t" + "2. " + A.get(10).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C==2) {
						J++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 마지막 스인개 학생들이 취업을 위해 여러 회사에 지원하고 있다.");
					System.out.println("\t "+Q.get(11).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(11).A1 + "\t" + "2. " + A.get(11).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if (C==2){
						T++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					if (E > I) {
						EI = "E";
					} else {
						EI = "I";
					}
					if (S > N) {
						SN = "S";
					} else {
						SN = "N";
					}
					if (F > T) {
						FT = "F";
					} else {
						FT = "T";
					}
					if (P > J) {
						PJ = "P";
					} else {
						PJ = "J";
					}
					MBTI1 = EI + SN + FT + PJ;
					System.out.println(
							 "\t  __        ______        ___       _______   __   __   __    _______             \n" +
			                "\t |  |      /  __  \\      /   \\     |       \\ |  | |  \\ |  |  /  _____|            \n" +
			                "\t |  |     |  |  |  |    /  ^  \\    |  .--.  ||  | |   \\|  | |  |  __              \n" +
			                "\t |  |     |  |  |  |   /  /_\\  \\   |  |  |  ||  | |    `  | |  | |_ |             \n" +
			                "\t |  `----.|  `--'  |  /  _____  \\  |  '--'  ||  | |  |\\   | |  |__| |  __  __  __ \n" +
			                "\t |_______| \\______/  /__/     \\__\\ |_______/ |__| |__| \\__|  \\______| (__)(__)(__)");

					Thread.sleep(3000);
					System.out.println();
					System.out.println("\t 당신의 학원테마 MBTI는!!!!");
					Thread.sleep(1000);
					dao.MBTI2(MBTI1);
					// System.out.println(MBTI1 + "입니다!");
					mp3.stop();
					mp3.play(comPath+"전체 브금음악.mp3");
					dto = new DTO(MBTI1, id, pw);
					row = dao.update2(dto);
					if (row > 0) {
						System.out.println("\t MBTI 업데이트 완료");
					} else {
						System.out.println("\t MBTI 업데이트 실패");

					}
					Q.clear();
					A.clear();
					while (true) {
						System.out.println("\t 다른 테마를 플레이하시겠습니까?");
						System.out.print("\t 1. 네 \t 2. 아니요 \t >> ");
						check = sc.nextInt();
						if (check == 1) {
							break;
						} else if (check == 2) {
							break;
						} else {
							System.out.println("\t 번호를 확인해주세요");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (check == 2) {
					break;
				}
			} else if (login == true && SelectTema == 3) {
				/////////////////////////////////////////////////////// 테마 3번

				try {
					mp3.stop();
					mp3.play(comPath+"회사테마.mp3");
					System.out.println("\t   ______   ______   .___  ___. .______      ___      .__   __. ____    ____ ");
			        System.out.println("\t  /      | /  __  \\  |   \\/   | |   _  \\    /   \\     |  \\ |  | \\   \\  /   / ");
			        System.out.println("\t |  ,----'|  |  |  | |  \\  /  | |  |_)  |  /  ^  \\    |   \\|  |  \\   \\/   /  ");
			        System.out.println("\t |  |     |  |  |  | |  |\\/|  | |   ___/  /  /_\\  \\   |  . `  |   \\_    _/   ");
			        System.out.println("\t |  `----.|  `--'  | |  |  |  | |  |     /  _____  \\  |  |\\   |     |  |     ");
			        System.out.println("\t  \\______| \\______/  |__|  |__| | _|    /__/     \\__\\ |__| \\__|     |__|     ");

			        System.out.println("\t [회사편]");

					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_3";
					String user = "cgi_23K_BIG23_p1_3";
					String passward = "smhrd3";
					conn = DriverManager.getConnection(url, user, passward);

					String sql = "select Q3, T3Result1, T3Result2 from tema3";

					psmt = conn.prepareStatement(sql);

					rs = psmt.executeQuery();

					while (rs.next()) {
						String Q1 = rs.getString("Q3");
						String A1 = rs.getString("T3Result1");
						String A2 = rs.getString("T3Result2");
						Q.add(new ArrayListConstructor(Q1));
						A.add(new ArrayListConstructor(A1, A2));
					}

					//////////////////////////////////////////////////
					System.out.println("\t 회사에 지원하려고 한다. 내일 면접을 보기로 했다. 너무 떨려서 친구에게 카톡을 보냈다.");
					System.out.println("\t "+Q.get(0).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(0).A1 + "\t" + "2. " + A.get(0).A2+"  >>  ");
					C = sc.nextInt();
					if (C == 1) {
						F++; break;
					} else if(C==2) {
						T++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 면접에서 준비하지 않은 예상치 못한 질문이 나왔다.");
					System.out.println("\t "+Q.get(1).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(1).A1 + "\t" + "2. " + A.get(1).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if(C==2){
						N++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 드디어 면접이 끝났다.");
					System.out.println("\t "+Q.get(2).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(2).A1 + "\t" + "2. " + A.get(2).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if (C==2){
						N++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 면접에 합격했고 내일은 내가 원하던 A 회사에 입사 날이다");
					System.out.println("\t "+Q.get(3).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(3).A1 + "\t" + "2. " + A.get(3).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C==2){
						J++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 신입사원 첫날이 되었다.");
					System.out.println("\t "+Q.get(4).Q);
					while(true){   
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(4).A1 + "\t" + "2. " + A.get(4).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if(C==2){
						I++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 직장생활을 하면서 교류가 적지만 친해지고 싶은 사람이 생겼다.");
					System.out.println("\t "+Q.get(5).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(5).A1 + "\t" + "2. " + A.get(5).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if(C==2) {
						I++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 오후 업무, 새로운 보고서를 처리해야 한다.");
					System.out.println("\t "+Q.get(6).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(6).A1 + "\t" + "2. " + A.get(6).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						S++; break;
					} else if(C==2){
						N++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 시간이 흐른 후 후임이 들어왔다.");
					System.out.println("\t "+Q.get(7).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(7).A1 + "\t" + "2. " + A.get(7).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C==2){
						J++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 마감일이 비교적 여유로운 업무가 줬다.");
					System.out.println("\t "+Q.get(8).Q);
					while(true){
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(8).A1 + "\t" + "2. " + A.get(8).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						P++; break;
					} else if(C==2){
						J++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 회의 도중 나의 의견과 다른 의견이 나왔다.");
					System.out.println("\t "+Q.get(9).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(9).A1 + "\t" + "2. " + A.get(9).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if(C==2){
						T++; break;
					}else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 회사 생활 도중 동료가 내 험담을 하고 다닌다는 것을 알았다.");
					System.out.println("\t "+Q.get(10).Q);
					while(true){ 
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(10).A1 + "\t" + "2. " + A.get(10).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						F++; break;
					} else if(C==2) {
						T++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					System.out.println("\t 승진하게 됐고 승진 기념 축하인사를 받게 되었다.");
					System.out.println("\t "+Q.get(11).Q);
					while(true){  
					System.out.println("\t 당신의 선택은?");
					System.out.print("\t 1. " + A.get(11).A1 + "\t" + "2. " + A.get(11).A2+"  >>  ");
					C = sc.nextInt();
					System.out.println();
					if (C == 1) {
						E++; break;
					} else if(C==2){
						I++; break;
					} else {
						System.out.println("\t !!번호를 다시 입력해주세요!!");
					}}
					//////////////////////////////////////////////////////////
					if (E > I) {
						EI = "E";
					} else {
						EI = "I";
					}
					if (S > N) {
						SN = "S";
					} else {
						SN = "N";
					}
					if (F > T) {
						FT = "F";
					} else {
						FT = "T";
					}
					if (P > J) {
						PJ = "P";
					} else {
						PJ = "J";
					}
					MBTI1 = EI + SN + FT + PJ;
//				System.out.println(MBTI1 + "입니다!");
					System.out.println(
							 "\t  __        ______        ___       _______   __   __   __    _______             \n" +
			                "\t |  |      /  __  \\      /   \\     |       \\ |  | |  \\ |  |  /  _____|            \n" +
			                "\t |  |     |  |  |  |    /  ^  \\    |  .--.  ||  | |   \\|  | |  |  __              \n" +
			                "\t |  |     |  |  |  |   /  /_\\  \\   |  |  |  ||  | |    `  | |  | |_ |             \n" +
			                "\t |  `----.|  `--'  |  /  _____  \\  |  '--'  ||  | |  |\\   | |  |__| |  __  __  __ \n" +
			                "\t |_______| \\______/  /__/     \\__\\ |_______/ |__| |__| \\__|  \\______| (__)(__)(__)");

					Thread.sleep(3000);
					System.out.println("\t 당신의 회사테마 MBTI는!!!!");
					System.out.println();
					Thread.sleep(1000);
					mp3.stop();
					mp3.play(comPath+"전체 브금음악.mp3");
					dao.MBTI3(MBTI1);
					dto = new DTO(MBTI1, id, pw);
					row = dao.update3(dto);
					if (row > 0) {
						System.out.println("\t MBTI 업데이트 완료");
					} else {
						System.out.println("\t MBTI 업데이트 실패");

					}
					Q.clear();
					A.clear();
					while (true) {
						System.out.println("\t 다른 테마를 플레이하시겠습니까?");
						System.out.print("\t 1. 네 \t 2. 아니요 \t >> ");
						check = sc.nextInt();
						if (check == 1) {
							break;
						} else if (check == 2) {
							break;
						} else {
							System.out.println("\t 번호를 확인해주세요");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					dao.getClose();
				}
				if (check == 2) {
					break;
				}
			}
		}
		System.out.println("\t\t\t 결과들을 확인하시겠습니까?");
		System.out.print("\t\t\t 1.예 \t\t 2.아니요\t >> ");
		check = sc.nextInt();
		if(check == 1 ) {
			DTO info =dao.getInfo(dto);
			System.out.println("\t\t"+info.getMbti1()+"\t\t\t"+info.getMbti2()+"\t\t\t"+info.getMbti3());
		}
		// 그림 넣을곳
	        System.out.println("\t .___________. __    __       ___      .__   __.  __  ___    ____    ____   ______    __    __  ");
	        System.out.println("\t |           ||  |  |  |     /   \\     |  \\ |  | |  |/  /    \\   \\  /   /  /  __  \\  |  |  |  | ");
	        System.out.println("\t `---|  |----`|  |__|  |    /  ^  \\    |   \\|  | |  '  /      \\   \\/   /  |  |  |  | |  |  |  | ");
	        System.out.println("\t     |  |     |   __   |   /  /_\\  \\   |  . `  | |    <        \\_    _/   |  |  |  | |  |  |  | ");
	        System.out.println("\t     |  |     |  |  |  |  /  _____  \\  |  |\\   | |  .  \\         |  |     |  `--'  | |  `--'  | ");
	        System.out.println("\t     |__|     |__|  |__| /__/     \\__\\ |__| \\__| |__|\\__\\        |__|      \\______/   \\______/  ");
	        
	        mp3.stop();
	        
	        check=sc.nextInt();
	}
}

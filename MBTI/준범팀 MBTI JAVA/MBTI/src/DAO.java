import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	protected Connection conn = null;
	protected PreparedStatement psmt = null;
	protected ResultSet rs = null;

	// DB연결 메소드
	protected void getConn() {
		try {
			// jdbc:mysql://[호스트명 또는 ip]:[포트]/[데이터베이스 이름]
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_3";
			String user = "cgi_23K_BIG23_p1_3";
			String passward = "smhrd3";
			conn = DriverManager.getConnection(url, user, passward);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 자원 반납 메소드
	protected void getClose() {
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

	// 회원가입 메소드
	protected int join(DTO dto) {

		int row = 0;
		try {

			getConn();

			String sql = "insert into info (id , pw , name)values(? ,? ,? );";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());

			row = psmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			getClose();
		}
		return row;
	}

	// mbti 업데이트
	protected int update1(DTO dto) {
		int up = 0;
		try {
			getConn();

			String sql = "update info set MBTI1 = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getMBTI1());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			up = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return up;

	}

	// 로그인 메소드
	protected DTO login(String id, String pw) {

		DTO dto = null;
		boolean login = false;
		try {

			getConn();

			String sql = "select * from info where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next() == true) {
				String name = rs.getString("name");
				dto = new DTO(null, null, null, name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;

	}

	// 정보조회 메소드
	protected DTO getInfo(DTO dto) {
		try {

			getConn();

			String sql = "select name, MBTI1, MBTI2, MBTI3 from info where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rs = psmt.executeQuery();
			System.out.println("\t\t\t========= 검사 기록 =========");
			System.out.println("\t\t학원\t\t\t연애\t\t\t회사");
			while (rs.next()) {
				String mbti1 = rs.getString("MBTI1");
				String mbti2 = rs.getString("MBTI2");
				String mbti3 = rs.getString("MBTI3");
				dto = new DTO(null, mbti1, mbti2, mbti3, null);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;

	}
	
	// mbti 결과문
	protected void MBTI1(String MBTI1) {
		if (MBTI1.equals("ISFP")) {
			System.out.println("\t  __       _______. _______ .______   \n" +
	                "\t |  |     /       ||   ____||   _  \\  \n" +
	                "\t |  |    |   (----`|  |__   |  |_)  | \n" +
	                "\t |  |     \\   \\    |   __|  |   ___/  \n" +
	                "\t |  | .----)   |   |  |     |  |      \n" +
	                "\t |__| |_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ISFP\n"
               + "\t 평소에 연애 관심X \n\t 공감력이 뛰어나 상대방을 잘 맞춰준다 \t 자신에게 소홀해질 수 있다.\n"
               + "\t 최고의 궁합 - 엄청난 결단력 ENTJ \t 최악의 궁합 - 자기애가 강력한 ENTP\n");
		} else if (MBTI1.equals("ENFP")) {
			System.out.println("\t  _______ .__   __.  _______ .______   \n" +
	                "\t |   ____||  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  |__   |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |   __|  |  . `  | |   __|  |   ___/  \n" +
	                "\t |  |____ |  |\\   | |  |     |  |      \n" +
	                "\t |_______||__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t ENFP\n"
               + "\t 연인과 함께라면 언제든 OK \n\t 연인에게 올인 \t 헌신적인 연애\n"
               + "\t 최고의 궁합 - 다정하게 컨트롤 해주는 INFJ \t 최악의 궁합 - 성실의 끝판왕 ISFJ\n");
		} else if (MBTI1.equals("ESFP")) {
			System.out.println("\t  _______      _______. _______ .______   \n" +
	                "\t |   ____|    /       ||   ____||   _  \\  \n" +
	                "\t |  |__      |   (----`|  |__   |  |_)  | \n" +
	                "\t |   __|      \\   \\    |   __|  |   ___/  \n" +
	                "\t |  |____ .----)   |   |  |     |  |      \n" +
	                "\t |_______||_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ESFP\n"
               + "\t 연인에게 헌신 \n\t 이벤트 자주 기획 \t 연인이 인생의 1순위 \n"
               + "\t 최고의 궁합 - 한번 빠지면 헤어 나오지 못하는 INTJ \t 최악의 궁합 - 쿨을 넘은 무심함 INTP\n");
		} else if (MBTI1.equals("INFP")) {
			System.out.println("\t  __  .__   __.  _______ .______   \n" +
	                "\t |  | |  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  | |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |  | |  . `  | |   __|  |   ___/  \n" +
	                "\t |  | |  |\\   | |  |     |  |      \n" +
	                "\t |__| |__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t INFP\n"
               + "\t 로맨틱한 연애를 꿈꾼다 \n\t 사귀기 전에는 벽을 치지만 사귄 후에는 적극적인 애정표현\n"
               + "\t 최고의 궁합 - 진솔한 대화가 통하는 ISFP \t 최악의 궁합 - 사랑의 불도저 ESFP\n");
		} else if (MBTI1.equals("ESFJ")) {
			System.out.println("\t  _______      _______. _______        __  \n" +
	                "\t |   ____|    /       ||   ____|      |  |\n" +
	                "\t |  |__      |   (----`|  |__         |  |\n" +
	                "\t |   __|      \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  |____ .----)   |   |  |     |  `--'  |\n" +
	                "\t |_______||_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESFJ\n"
               + "\t 연인의 감정을 잘 읽고 맞춰줌 \n\t 갈등을 만들고 싶지 않아 속에 쌓아둔다\n"
               + "\t 최고의 궁합 - 연애의 재미를 즐기는 INTP \t 최악의 궁합 - 내가 바로 리더다 ENTJ\n");
		} else if (MBTI1.equals("ENFJ")) {
			System.out.println("\t  _______ .__   __.  _______        __  \n" +
	                "\t |   ____||  \\ |  | |   ____|      |  |\n" +
	                "\t |  |__   |   \\|  | |  |__         |  |\n" +
	                "\t |   __|  |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  |____ |  |\\   | |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ENFJ\n"
            + "\t 눈치가 빨라 연인의 감정을 잘 캐치 \n\t 장점을 알아보고 응원해줌. \t 부정적인 편\n"
               + "\t 최고의 궁합 - 질문폭격기 ISTP \t 최악의 궁합 - 신중해서 알 수 없는 ISTJ\n");
		} else if (MBTI1.equals("ISFJ")) {
			System.out.println("\t  __       _______. _______        __  \n" +
	                "\t |  |     /       ||   ____|      |  |\n" +
	                "\t |  |    |   (----`|  |__         |  |\n" +
	                "\t |  |     \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  | .----)   |   |  |     |  `--'  |\n" +
	                "\t |__| |_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ISFJ\n"
               + "\t 평화의 수호신 \n\t 아낌없이 사랑을 준다 \n\t 상대의 사랑을 확인받고 싶어한다.\n"
               + "\t 최고의 궁합 - 통통 튀는 매력의 ESTP \t 최악의 궁합 - 과한 에너자이저 ENFP\n");
		} else if (MBTI1.equals("INFJ")) {
			System.out.println("\t  __  .__   __.  _______        __  \n" +
	                "\t |  | |  \\ |  | |   ____|      |  |\n" +
	                "\t |  | |   \\|  | |  |__         |  |\n" +
	                "\t |  | |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  | |  |\\   | |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t INFJ\n"
               + "\t 거리가 가까울수록 애정의 크기 상승 \n\t 표현이 서툰다 \t 상대에게 올인\n"
               + "\t 최고의 궁합 - 사랑의 불도저 ESFP \t 최악의 궁합 - 보이지 않는 벽 ESTJ\n");
		} else if (MBTI1.equals("ESTP")) {
			System.out.println("\t  _______      _______..___________..______   \n" +
	                "\t |   ____|    /       ||           ||   _  \\  \n" +
	                "\t |  |__      |   (----``---|  |----`|  |_)  | \n" +
	                "\t |   __|      \\   \\        |  |     |   ___/  \n" +
	                "\t |  |____ .----)   |       |  |     |  |      \n" +
	                "\t |_______||_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println( "\t ESTP\n"
               + "\t 사교성과 추진력이 좋다 \n\t 충동적 \t 불도저 같은 모습\n"
               + "\t 최고의 궁합 - Give and Take INFJ \t 최악의 궁합 - 주도권은 나에게 INFP\n");
		} else if (MBTI1.equals("ENTP")) {
			System.out.println("\t  _______ .__   __. .___________..______   \n" +
	                "\t |   ____||  \\ |  | |           ||   _  \\  \n" +
	                "\t |  |__   |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |   __|  |  . `  |     |  |     |   ___/  \n" +
	                "\t |  |____ |  |\\   |     |  |     |  |      \n" +
	                "\t |_______||__| \\__|     |__|     |__|      ");
	        System.out.println();
	        System.out.println("\t ENTP\n"
               + "\t 개인의 시간을 중요시 생각 \n\t 자기애가 강한편 \t 지루할 틈 없이 다이나믹한 연애 \n"
               + "\t 최고의 궁합 - 다 맞춰주는 ISFJ \t 최악의 궁합 - 진심을 꾸준하게 갈구하는 ISFP\n");
		} else if (MBTI1.equals("ISTP")) {
			System.out.println("\t  __       _______..___________..______   \n" +
	                "\t |  |     /       ||           ||   _  \\  \n" +
	                "\t |  |    |   (----``---|  |----`|  |_)  | \n" +
	                "\t |  |     \\   \\        |  |     |   ___/  \n" +
	                "\t |  | .----)   |       |  |     |  |      \n" +
	                "\t |__| |_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t ISTP\n"
               + "\t 선을 지키면서 단계를 밟아가는 사랑 추구 \n\t  사생활 중요시 여긴다 \t 다소 소극적인편\n"
               + "\t 최고의 궁합 - 감정의 신뢰가 가장 높은 ESFJ \t 최악의 궁합 - 통제 불능 자유로운 ESFP\n");
		} else if (MBTI1.equals("INTP")) {
			System.out.println("\t  __  .__   __. .___________..______   \n" +
	                "\t |  | |  \\ |  | |           ||   _  \\  \n" +
	                "\t |  | |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |  | |  . `  |     |  |     |   ___/  \n" +
	                "\t |  | |  |\\   |     |  |     |  |      \n" +
	                "\t |__| |__| \\__|     |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t INTP\n"
               + "\t 귀찮은 것을 싫어함 \n\t 무심한편 \t 상대의 사고방식, 대화가 나와 잘 맞는지가 중요\n"
               + "\t 최고의 궁합 - 무심해도 이해해주는 ENFJ \t 최악의 궁합 - 계속된 감정의 요구 INFJ\n");
		} else if (MBTI1.equals("ESTJ")) {
			System.out.println("\t  _______      _______..___________.       __  \n" +
	                "\t |   ____|    /       ||           |      |  |\n" +
	                "\t |  |__      |   (----``---|  |----`      |  |\n" +
	                "\t |   __|      \\   \\        |  |     .--.  |  |\n" +
	                "\t |  |____ .----)   |       |  |     |  `--'  |\n" +
	                "\t |_______||_______/        |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESTJ\n"
               + "\t 계획적인  성향 \n\t 약속을 반드시 지킨다 \t 노력파\n"
               + "\t 최고의 궁합 - 통통 튀는 매력의 INFP \t 최악의 궁합 - 절대 먼저 오지 않는 INFJ\n");
		} else if (MBTI1.equals("ENTJ")) {
			System.out.println("\t  _______ .__   __. .___________.       __  \n" +
	                "\t |   ____||  \\ |  | |           |      |  |\n" +
	                "\t |  |__   |   \\|  | `---|  |----`      |  |\n" +
	                "\t |   __|  |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  |____ |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__|     |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ENTJ\n"
               + "\t 리더십을 발휘 \n\t 싸울 때도 잘잘못을 따진다 \t 소유욕이 강해서 유혹하는데 뛰어남\n"
               + "\t 최고의 궁합 - 낭만과 로맨틱의 ISFP \t 최악의 궁합 - 과하게 친절한 ISFJ\n");
		} else if (MBTI1.equals("ISTJ")) {
			System.out.println("\t  __       _______..___________.       __  \n" +
	                "\t |  |     /       ||           |      |  |\n" +
	                "\t |  |    |   (----``---|  |----`      |  |\n" +
	                "\t |  |     \\   \\        |  |     .--.  |  |\n" +
	                "\t |  | .----)   |       |  |     |  `--'  |\n" +
	                "\t |__| |_______/        |__|      \\______/ ");
	           System.out.println("");
	           System.out.println("\t ISTJ\n"
               + "\t 꼼꼼하고 철두철미하며 감정표현이 서툴어 내적 사랑이 가득함 \n\t  연애 기간이 긴 편이다\n"
               + "\t 최고의 궁합 - 해피 바이러스 ENFP \t 최악의 궁합 - 자꾸만 한숨이 튀어나오는 INFP\n");
		} else if (MBTI1.equals("INTJ")) {
			System.out.println("\t  __  .__   __. .___________.       __  \n" +
	                "\t |  | |  \\ |  | |           |      |  |\n" +
	                "\t |  | |   \\|  | `---|  |----`      |  |\n" +
	                "\t |  | |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  | |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__|     |__|      \\______/ ");
	           System.out.println();
	           System.out.println("\t INTJ\n"
               + "\t 자신의 감정을 잘 숨김 \n\t 호불호가 강하고 주관이 뚜렷 \t 조용하고 깊은 사랑 추구\n"
               + "\t 최고의 궁합 - 강아지 스타일의 ENFP \t 최악의 궁합 - 나랑 같은 건 절대 NO INTJ\n");
		}

	}
	protected void MBTI2(String MBTI1) {
		if (MBTI1.equals("ISFP")) {
			System.out.println("\t  __       _______. _______ .______   \n" +
	                "\t |  |     /       ||   ____||   _  \\  \n" +
	                "\t |  |    |   (----`|  |__   |  |_)  | \n" +
	                "\t |  |     \\   \\    |   __|  |   ___/  \n" +
	                "\t |  | .----)   |   |  |     |  |      \n" +
	                "\t |__| |_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ENFJ\r\n"
					+ "\t 인기 쟁이 타입! 매일 보면 친구들한테 둘러 쌓여 있음!\r\n"
					+ "\t 좋은관계 : ENFP, INFJ, ENFJ, INTJ, ENTJ, INTP, ENTP\r\n"
					+ "\t 안맞아요: ESFP, ISTP, ESTP, ISFJ, ESFJ, ISTJ, ESTJ");
		} else if (MBTI1.equals("ENFP")) {
			System.out.println("\t  _______ .__   __.  _______ .______   \n" +
	                "\t |   ____||  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  |__   |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |   __|  |  . `  | |   __|  |   ___/  \n" +
	                "\t |  |____ |  |\\   | |  |     |  |      \n" +
	                "\t |_______||__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t ENFP\r\n"
					+ "\t 항상 친구 옆에 착! 붙어있는 애교쟁이. 스킨십 쟁이.\r\n"
					+ "\t 좋은관계 : INFP, ENFP, ENFJ, ENTJ, INTP, ENTP\r\n"
					+ "\t 안맞아요 : ISFP, ESFP, ISTP, ESTP, ISFJ, ESFJ, ISTJ, ESTJ\n");
		} else if (MBTI1.equals("ESFP")) {
			System.out.println("\t  _______      _______. _______ .______   \n" +
	                "\t |   ____|    /       ||   ____||   _  \\  \n" +
	                "\t |  |__      |   (----`|  |__   |  |_)  | \n" +
	                "\t |   __|      \\   \\    |   __|  |   ___/  \n" +
	                "\t |  |____ .----)   |   |  |     |  |      \n" +
	                "\t |_______||_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ESFP\r\n"
					+ "\t 댄스부 메인 멤버! 축제를 휩쓰는 학교의 유명인사\r\n"
					+ "\t 좋은관계 : 없습니다.\r\n"
					+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("INFP")) {
			System.out.println("\t  __  .__   __.  _______ .______   \n" +
	                "\t |  | |  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  | |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |  | |  . `  | |   __|  |   ___/  \n" +
	                "\t |  | |  |\\   | |  |     |  |      \n" +
	                "\t |__| |__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t INFP\r\n"
					+ "\t 찐친 한정 흥부자 타입! 막상 앞에 나가면 내성적으로 변함\r\n"
					+ "\t 좋은관계 : INFP, ENFP, INFJ, INTJ, INTP, ENTP\r\n"
					+ "\t 안맞아요 : ISFP, ESFP, ISTP, ESTP, ISFJ, ESFJ, ISTJ, ESTJ\n");
		} else if (MBTI1.equals("ESFJ")) {
			System.out.println("\t  _______      _______. _______        __  \n" +
	                "\t |   ____|    /       ||   ____|      |  |\n" +
	                "\t |  |__      |   (----`|  |__         |  |\n" +
	                "\t |   __|      \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  |____ .----)   |   |  |     |  `--'  |\n" +
	                "\t |_______||_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESFJ\r\n"
	        		+ "\t 오늘만 봐줄게! 자주 봐주는 선도부 사람\r\n"
	        		+ "\t 좋은관계 : ISFJ, ESFJ, ISTJ, ESTJ\r\n"
	        		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("ENFJ")) {
			System.out.println("\t  _______ .__   __.  _______        __  \n" +
	                "\t |   ____||  \\ |  | |   ____|      |  |\n" +
	                "\t |  |__   |   \\|  | |  |__         |  |\n" +
	                "\t |   __|  |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  |____ |  |\\   | |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ENFJ\r\n"
	        		+ "\t 인기 쟁이 타입! 매일 보면 친구들한테 둘러 쌓여 있음!\r\n"
	        		+ "\t 좋은관계 : ENFP, INFJ, ENFJ, INTJ, ENTJ, INTP, ENTP\r\n"
	        		+ "\t 안맞아요: ESFP, ISTP, ESTP, ISFJ, ESFJ, ISTJ, ESTJ\n");
		} else if (MBTI1.equals("ISFJ")) {
			System.out.println("\t  __       _______. _______        __  \n" +
	                "\t |  |     /       ||   ____|      |  |\n" +
	                "\t |  |    |   (----`|  |__         |  |\n" +
	                "\t |  |     \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  | .----)   |   |  |     |  `--'  |\n" +
	                "\t |__| |_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ISFJ\r\n"
	        		+ "\t 내꺼 보고 해! 숙제를 빌려주는 착한 친구 타입\r\n"
	        		+ "\t 좋은관계 : ISFJ, ESFJ, ISTJ, ESTJ\r\n"
	        		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("INFJ")) {
			System.out.println("\t  __  .__   __.  _______        __  \n" +
	                "\t |  | |  \\ |  | |   ____|      |  |\n" +
	                "\t |  | |   \\|  | |  |__         |  |\n" +
	                "\t |  | |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  | |  |\\   | |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t INFJ\r\n"
	        		+ "\t 선행상 싹쓸이 하는 모범생의 표본! 담임쌤이 제일 좋아함\r\n"
	        		+ "\t 좋은관계 : INFP, INFJ, ENFJ, INTJ, ENTJ, INTP\r\n"
	        		+ "\t 안맞아요 : ISFP, ESFP, ISTP, ESTP, ISFJ, ESFJ, ISTJ, ESTJ\n");
		} else if (MBTI1.equals("ESTP")) {
			System.out.println("\t  _______      _______..___________..______   \n" +
	                "\t |   ____|    /       ||           ||   _  \\  \n" +
	                "\t |  |__      |   (----``---|  |----`|  |_)  | \n" +
	                "\t |   __|      \\   \\        |  |     |   ___/  \n" +
	                "\t |  |____ .----)   |       |  |     |  |      \n" +
	                "\t |_______||_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println( "\t ESTP\r\n"
	        		+ "\t 학생회 단골 멤버 항상 학생회 일로 바쁜 타입!\r\n"
	        		+ "\t 좋은관계 : 없습니다.\r\n"
	        		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("ENTP")) {
			System.out.println("\t  _______ .__   __. .___________..______   \n" +
	                "\t |   ____||  \\ |  | |           ||   _  \\  \n" +
	                "\t |  |__   |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |   __|  |  . `  |     |  |     |   ___/  \n" +
	                "\t |  |____ |  |\\   |     |  |     |  |      \n" +
	                "\t |_______||__| \\__|     |__|     |__|      ");
	        System.out.println();
	        System.out.println("\t 선생님 그건 아닌 것 같은데요? 매번 토를 다는 타입\r\n"
	        		+ "\t 좋은관계 : INFP, ENFP, ENFJ, ENTJ, INTP, ENTP\r\n"
	        		+ "\t 안맞아요 : 없습니다.\n");
		} else if (MBTI1.equals("ISTP")) {
			System.out.println("\t  __       _______..___________..______   \n" +
	                "\t |  |     /       ||           ||   _  \\  \n" +
	                "\t |  |    |   (----``---|  |----`|  |_)  | \n" +
	                "\t |  |     \\   \\        |  |     |   ___/  \n" +
	                "\t |  | .----)   |       |  |     |  |      \n" +
	                "\t |__| |_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t ISTP\r\n"
	        		+ "\t 매일 노는 것 같고 매일 자는 것 같은데 알고보니 전교권\r\n"
	        		+ "\t 좋은관계 : 없습니다.\r\n"
	        		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("INTP")) {
			System.out.println("\t  __  .__   __. .___________..______   \n" +
	                "\t |  | |  \\ |  | |           ||   _  \\  \n" +
	                "\t |  | |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |  | |  . `  |     |  |     |   ___/  \n" +
	                "\t |  | |  |\\   |     |  |     |  |      \n" +
	                "\t |__| |__| \\__|     |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t INTP\r\n"
	        		+ "\t 오늘도 도서관이니? 도서관 단골 자리 항상 사수하는 도서관러!\r\n"
	        		+ "\t 좋은관계 : INFP, ENFP, INFJ, ENFJ, INTJ, INTP, ENTP\r\n"
	        		+ "\t 안맞아요 : 없습니다\n");
		} else if (MBTI1.equals("ESTJ")) {
			System.out.println("\t  _______      _______..___________.       __  \n" +
	                "\t |   ____|    /       ||           |      |  |\n" +
	                "\t |  |__      |   (----``---|  |----`      |  |\n" +
	                "\t |   __|      \\   \\        |  |     .--.  |  |\n" +
	                "\t |  |____ .----)   |       |  |     |  `--'  |\n" +
	                "\t |_______||_______/        |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESTJ\r\n"
	        		+ "\t 학교의 자랑거리! 믿고 의지하는 학생회장 타입\r\n"
	        		+ "\t 좋은관계 : ISFJ, ESFJ, ISTJ, ESTJ\r\n"
	        		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("ENTJ")) {
			System.out.println("\t  _______ .__   __. .___________.       __  \n" +
	                "\t |   ____||  \\ |  | |           |      |  |\n" +
	                "\t |  |__   |   \\|  | `---|  |----`      |  |\n" +
	                "\t |   __|  |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  |____ |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__|     |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t INTJ와 전교 등수를 다투는 타입! 전교권 물에서만 논다\r\n"
	        		+ "\t 좋은관계 : ENFP, INFJ, ENFJ, INTJ, ENTJ, ENTP\r\n"
	        		+ "\t 안맞아요 : 없습니다.\n");
		} else if (MBTI1.equals("ISTJ")) {
			System.out.println("\t  __       _______..___________.       __  \n" +
	                "\t |  |     /       ||           |      |  |\n" +
	                "\t |  |    |   (----``---|  |----`      |  |\n" +
	                "\t |  |     \\   \\        |  |     .--.  |  |\n" +
	                "\t |  | .----)   |       |  |     |  `--'  |\n" +
	                "\t |__| |_______/        |__|      \\______/ ");
	           System.out.println("");
	           System.out.println("\t 조용조용 무난무난 조용한 모범생 타입\r\n"
	           		+ "\t 좋은관계 : ISFJ, ESFJ, ISTJ, ESTJ\r\n"
	           		+ "\t 안맞아요 : INFP, ENFP, INFJ, ENFJ\n");
		} else if (MBTI1.equals("INTJ")) {
			System.out.println("\t  __  .__   __. .___________.       __  \n" +
	                "\t |  | |  \\ |  | |           |      |  |\n" +
	                "\t |  | |   \\|  | `---|  |----`      |  |\n" +
	                "\t |  | |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  | |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__|     |__|      \\______/ ");
	           System.out.println();
	           System.out.println("\t INTJ\r\n"
	           		+ "\t 하루종일 책상에 앉아 공부하는 전교 1등 유형\r\n"
	           		+ "\t 좋은관계 : INFP, INFJ, ENFJ, INTJ, ENTJ, INTP\r\n"
	           		+ "\t 안맞아요 : 없습니다\n");
		}

	}
	protected void MBTI3(String MBTI1) {
		if (MBTI1.equals("ISFP")) {
			System.out.println("\t  __       _______. _______ .______   \n" +
	                "\t |  |     /       ||   ____||   _  \\  \n" +
	                "\t |  |    |   (----`|  |__   |  |_)  | \n" +
	                "\t |  |     \\   \\    |   __|  |   ___/  \n" +
	                "\t |  | .----)   |   |  |     |  |      \n" +
	                "\t |__| |_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ISFP\r\n"
					+ "\t 현재의 삶을 즐기는 것을 가장 중요하게 여김. 손재주도 좋고 예술적인 것에 재능이 많음.\r\n"
					+ "\t 비폭력 불복종\n");
		} else if (MBTI1.equals("ENFP")) {
			System.out.println("\t  _______ .__   __.  _______ .______   \n" +
	                "\t |   ____||  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  |__   |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |   __|  |  . `  | |   __|  |   ___/  \n" +
	                "\t |  |____ |  |\\   | |  |     |  |      \n" +
	                "\t |_______||__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t ENFP\r\n"
					+ "\t 덕후기질이 있음. 자신이 관심있는 일을 선택하는 것이 중요하며, 적성에 잘 맞는 업무를 맡게되면\r\n"
					+ "\t 폭발적인 에너지를 발휘함. 빨리 끝내고 놀고 싶어함.\n");
		} else if (MBTI1.equals("ESFP")) {
			System.out.println("\t  _______      _______. _______ .______   \n" +
	                "\t |   ____|    /       ||   ____||   _  \\  \n" +
	                "\t |  |__      |   (----`|  |__   |  |_)  | \n" +
	                "\t |   __|      \\   \\    |   __|  |   ___/  \n" +
	                "\t |  |____ .----)   |   |  |     |  |      \n" +
	                "\t |_______||_______/    |__|     | _|      ");
			System.out.println();
			System.out.println("\t ESFP\r\n"
					+ "\t 회사에서 알아주는 수다쟁이\r\n"
					+ "\t 관종 그 자체\n");
		} else if (MBTI1.equals("INFP")) {
			System.out.println("\t  __  .__   __.  _______ .______   \n" +
	                "\t |  | |  \\ |  | |   ____||   _  \\  \n" +
	                "\t |  | |   \\|  | |  |__   |  |_)  | \n" +
	                "\t |  | |  . `  | |   __|  |   ___/  \n" +
	                "\t |  | |  |\\   | |  |     |  |      \n" +
	                "\t |__| |__| \\__| |__|     | _|      ");
			System.out.println();
			System.out.println("\t INFP\r\n"
					+ "\t '회사생활 안맞아.. 그냥 집에 보내주라..'라는 생각을 많이 하는 편\r\n"
					+ "\t 있는 듯 없는 듯 있다가 퇴근함.\n");
		} else if (MBTI1.equals("ESFJ")) {
			System.out.println("\t  _______      _______. _______        __  \n" +
	                "\t |   ____|    /       ||   ____|      |  |\n" +
	                "\t |  |__      |   (----`|  |__         |  |\n" +
	                "\t |   __|      \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  |____ .----)   |   |  |     |  `--'  |\n" +
	                "\t |_______||_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESFJ\r\n"
	        		+ "\t 동료들을 편하게 만들어줌. 조화로운 분위기 메이커\r\n"
	        		+ "\t 일보다는 친목질.\n");
		} else if (MBTI1.equals("ENFJ")) {
			System.out.println("\t  _______ .__   __.  _______        __  \n" +
	                "\t |   ____||  \\ |  | |   ____|      |  |\n" +
	                "\t |  |__   |   \\|  | |  |__         |  |\n" +
	                "\t |   __|  |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  |____ |  |\\   | |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ENFJ\r\n"
	        		+ "\t 다정한 말투로 사람을 잘다룸. 끈끈한 동료애를 만드는 장본인.\r\n"
	        		+ "\t 팀 내 프레젠테이션 담당 말빨의 황제\n");
		} else if (MBTI1.equals("ISFJ")) {
			System.out.println("\t  __       _______. _______        __  \n" +
	                "\t |  |     /       ||   ____|      |  |\n" +
	                "\t |  |    |   (----`|  |__         |  |\n" +
	                "\t |  |     \\   \\    |   __|  .--.  |  |\n" +
	                "\t |  | .----)   |   |  |     |  `--'  |\n" +
	                "\t |__| |_______/    |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ISFJ\r\n"
	        		+ "\t 눈치와 센스가 빠름. 뒤에서 묵묵히 동료들을 다독임.\r\n"
	        		+ "\t 말 잘 듣는 일꾼.\n");
		} else if (MBTI1.equals("INFJ")) {
			System.out.println("\t  __  .__   __.  _______        __  \n" +
	                "\t |  | |  \\ |  | |   ____|      |  |\n" +
	                "\t |  | |   \\|  | |  |__         |  |\n" +
	                "\t |  | |  . `  | |   __|  .--.  |  |\n" +
	                "\t |  | |  |\\   | |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__| |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t INFJ\r\n"
	        		+ "\t 조직의 이익 및 화합을 추구하는 이타적인 성격.\r\n"
	        		+ "\t 시키기도 전에 일을 끝냄.\n");
		} else if (MBTI1.equals("ESTP")) {
			System.out.println("\t  _______      _______..___________..______   \n" +
	                "\t |   ____|    /       ||           ||   _  \\  \n" +
	                "\t |  |__      |   (----``---|  |----`|  |_)  | \n" +
	                "\t |   __|      \\   \\        |  |     |   ___/  \n" +
	                "\t |  |____ .----)   |       |  |     |  |      \n" +
	                "\t |_______||_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println( "\t ESTP\r\n"
	        		+ "\t 성취욕이 강함. 사무실의 행동파 대장.\r\n"
	        		+ "\t 마이웨이가 큼.\n");
		} else if (MBTI1.equals("ENTP")) {
			System.out.println("\t  _______ .__   __. .___________..______   \n" +
	                "\t |   ____||  \\ |  | |           ||   _  \\  \n" +
	                "\t |  |__   |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |   __|  |  . `  |     |  |     |   ___/  \n" +
	                "\t |  |____ |  |\\   |     |  |     |  |      \n" +
	                "\t |_______||__| \\__|     |__|     |__|      ");
	        System.out.println();
	        System.out.println("\t ENTP\r\n"
	        		+ "\t 하고 싶은 말은 다해야 함. 돌직구의 귀재.\r\n"
	        		+ "\t 얼떨결에 제일 힘든 일을 많이 함.\n");
		} else if (MBTI1.equals("ISTP")) {
			System.out.println("\t  __       _______..___________..______   \n" +
	                "\t |  |     /       ||           ||   _  \\  \n" +
	                "\t |  |    |   (----``---|  |----`|  |_)  | \n" +
	                "\t |  |     \\   \\        |  |     |   ___/  \n" +
	                "\t |  | .----)   |       |  |     |  |      \n" +
	                "\t |__| |_______/        |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t ISTP\r\n"
	        		+ "\t 조용하지만 착실하게 일함.\r\n"
	        		+ "\t \"말은 없는데 일은 참 잘해\"란 소리를 들음\r\n"
	        		+ "\t 알고보니 쓸모없는 잡학사전인 경우가 있음.\n");
		} else if (MBTI1.equals("INTP")) {
			System.out.println("\t  __  .__   __. .___________..______   \n" +
	                "\t |  | |  \\ |  | |           ||   _  \\  \n" +
	                "\t |  | |   \\|  | `---|  |----`|  |_)  | \n" +
	                "\t |  | |  . `  |     |  |     |   ___/  \n" +
	                "\t |  | |  |\\   |     |  |     |  |      \n" +
	                "\t |__| |__| \\__|     |__|     | _|      ");
	        System.out.println();
	        System.out.println("\t INTP\r\n"
	        		+ "\t 혁신적인 아이디어를 끊임없이 내는 편. 정작 공은 못 챙긴다고 함..\r\n"
	        		+ "\t 고집불통 막내 사원\n");
		} else if (MBTI1.equals("ESTJ")) {
			System.out.println("\t  _______      _______..___________.       __  \n" +
	                "\t |   ____|    /       ||           |      |  |\n" +
	                "\t |  |__      |   (----``---|  |----`      |  |\n" +
	                "\t |   __|      \\   \\        |  |     .--.  |  |\n" +
	                "\t |  |____ .----)   |       |  |     |  `--'  |\n" +
	                "\t |_______||_______/        |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ESTJ\r\n"
	        		+ "\t 논리적이고 분석적임. 타고난 팀장.\r\n"
	        		+ "\t 꼰대의 끝판왕.\n");
		} else if (MBTI1.equals("ENTJ")) {
			System.out.println("\t  _______ .__   __. .___________.       __  \n" +
	                "\t |   ____||  \\ |  | |           |      |  |\n" +
	                "\t |  |__   |   \\|  | `---|  |----`      |  |\n" +
	                "\t |   __|  |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  |____ |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |_______||__| \\__|     |__|      \\______/ ");
	        System.out.println();
	        System.out.println("\t ENTJ\r\n"
	        		+ "\t 회사에서 소문난 일잘하는사람. \r\n"
	        		+ "\t 논리적이고 분석적임. 타고난 팀장.\r\n"
	        		+ "\t 살짝 갑질 가능성 있음.\n");
		} else if (MBTI1.equals("ISTJ")) {
			System.out.println("\t  __       _______..___________.       __  \n" +
	                "\t |  |     /       ||           |      |  |\n" +
	                "\t |  |    |   (----``---|  |----`      |  |\n" +
	                "\t |  |     \\   \\        |  |     .--.  |  |\n" +
	                "\t |  | .----)   |       |  |     |  `--'  |\n" +
	                "\t |__| |_______/        |__|      \\______/ ");
	           System.out.println("");
	           System.out.println("\t ISTJ\r\n"
	           		+ "\t 원리원칙에 따른 일처리, 책임강이 강함,.\r\n"
	           		+ "\t 선비정신, 공무원이 많음.\n");
		} else if (MBTI1.equals("INTJ")) {
			System.out.println("\t  __  .__   __. .___________.       __  \n" +
	                "\t |  | |  \\ |  | |           |      |  |\n" +
	                "\t |  | |   \\|  | `---|  |----`      |  |\n" +
	                "\t |  | |  . `  |     |  |     .--.  |  |\n" +
	                "\t |  | |  |\\   |     |  |     |  `--'  |\n" +
	                "\t |__| |__| \\__|     |__|      \\______/ ");
	           System.out.println();
	           System.out.println("\t INTJ\r\n"
	           		+ "\t 목적달성을 위해 무자비하게 일을 추진함. 혼자서 일하는 편.\r\n"
	           		+ "\t 잘되면 내 덕 못되면 니 탓\n");
		}

	}

	protected int update2(DTO dto) {
		int up = 0;
		try {
			getConn();

			String sql = "update info set MBTI2 = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getMBTI1());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			up = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return up;

	}
	
	protected int update3(DTO dto) {
		int up = 0;
		try {
			getConn();

			String sql = "update info set MBTI3 = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getMBTI1());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			up = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return up;

	}
	protected void pick() {
		System.out.println("\t .----------------.  .----------------.  .----------------.  .----------------. \r\n"
				+ "\t | .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
				+ "\t | |   ______     | || |     _____    | || |     ______   | || |  ___  ____   | |\r\n"
				+ "\t | |  |_   __ \\   | || |    |_   _|   | || |   .' ___  |  | || | |_  ||_  _|  | |\r\n"
				+ "\t | |    | |__) |  | || |      | |     | || |  / .'   \\_|  | || |   | |_/ /    | |\r\n"
				+ "\t | |    |  ___/   | || |      | |     | || |  | |         | || |   |  __'.    | |\r\n"
				+ "\t | |   _| |_      | || |     _| |_    | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |\r\n"
				+ "\t | |  |_____|     | || |    |_____|   | || |   `._____.'  | || | |____||____| | |\r\n"
				+ "\t | |              | || |              | || |              | || |              | |\r\n"
				+ "\t | '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
				+ "\t  '----------------'  '----------------'  '----------------'  '----------------' ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	 
}




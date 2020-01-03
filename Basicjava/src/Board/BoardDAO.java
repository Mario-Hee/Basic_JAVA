package Board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSeesionFactory = SqlMapConfig.getsqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	int result;

	public void insertboard(BoardDTO bDto) {
		sqlSession = sqlSeesionFactory.openSession(true);

		try {
			result = sqlSession.insert("insertboard", bDto);

			if (result > 0) {
				System.out.println("▶▶" + bDto.getTitle() + "게시글을 등록하였습니다.");
			} else {
				System.out.println("▶▶ 게시글 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void updateboard(int bno, String title, String content) {
		sqlSession = sqlSeesionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);

		try {
			BoardDTO bDto = new BoardDTO(bno, title, content);
			result = sqlSession.update("updateboard", bDto);

			if (result > 0) {
				System.out.println("▶▶" + bDto.getTitle() + "게시글을 수정하였습니다.");
			} else {
				System.out.println("▶▶ 게시글 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteboard(int bno) {
		sqlSession = sqlSeesionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);

		try {
			result = sqlSession.delete("deleteboard", bno);

			if (result > 0) {
				System.out.println("▶▶" + bno + "게시글을 삭제하였습니다.");
			} else {
				System.out.println("▶▶ 게시글 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void selectboard() {
		sqlSession = sqlSeesionFactory.openSession();
		try {
			list = sqlSession.selectList("selectboard");

			if (result > 0) {
				System.out.println("▶▶ 번호\t 제목\t 내용\t 작성자\t 작성일자");
			}
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void searchboard(String Keyword) {
		sqlSession = sqlSeesionFactory.openSession();
		try {
			list = sqlSession.selectList("searchboard", "%" + Keyword + "%");

			if (result > 0) {
				System.out.println("▶▶ " + Keyword + "게시글을 검색하였습니다.");
			}

			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void sortboard() {
		sqlSession = sqlSeesionFactory.openSession();

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void viewboard() {
	}

}

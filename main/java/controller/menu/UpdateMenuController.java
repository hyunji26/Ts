package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Menu;
import model.service.MenuManager;

public class UpdateMenuController implements Controller {

	// MenuManager 인스턴스 생성
	private MenuManager menuManager = new MenuManager();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 메뉴 ID 파라미터 가져오기 및 세션에 저장
		int menuId;
		int price;

			String menuIdParam = (String) request.getSession().getAttribute("menuId");
			menuId = Integer.parseInt(menuIdParam);

			try {	
				Menu selectedInfo = menuManager.SearchById(menuId);
				request.getSession().setAttribute("menuInfo", selectedInfo);
			} catch (Exception e) {
				request.setAttribute("result", "메뉴 정보를 가져오는 중 오류가 발생했습니다: " + e.getMessage());
				return "/owner/updateMenuForm.jsp";
			}

		// 입력 값 가져오기
		String modiMenuName = request.getParameter("menuName");
		String priceParam = request.getParameter("price");

		try {
			// 세션에서 menuId 가져오기
			Object menuIdSession = request.getSession().getAttribute("menuId");
			if (menuIdSession != null) {
				menuId = Integer.parseInt(menuIdSession.toString());
			} else {
				throw new IllegalArgumentException("메뉴 ID가 세션에서 유효하지 않습니다.");
			}

			// 가격 값 변환
			if (priceParam != null && !priceParam.isEmpty()) {
				price = Integer.parseInt(priceParam);
			} else {
				throw new NumberFormatException("가격 값이 유효하지 않습니다.");
			}
		} catch (NumberFormatException e) {
			// 숫자 변환 실패 처리
			return "/owner/updateMenuForm.jsp";
		} catch (IllegalArgumentException e) {
			// 메뉴 ID가 유효하지 않을 경우
			request.setAttribute("result", e.getMessage());
			return "redirect:/owner/ownerMain";
		} catch (Exception e) {
			// 기타 예외 처리
			request.setAttribute("result", "오류 발생: " + e.getMessage());
			return "redirect:/owner/ownerMain";
		}

		// 메뉴 이름 유효성 검사
		if (modiMenuName == null || modiMenuName.isEmpty()) {
			request.setAttribute("result", "메뉴 이름을 입력해주세요.");
			return "/owner/updateMenuForm.jsp";
		}

		try {
			// 메뉴 업데이트 처리
			boolean updateResult = menuManager.updateMenu(modiMenuName, price, menuId);
			if (updateResult) {
				Menu selectedInfo = menuManager.SearchById(menuId);
				request.getSession().setAttribute("menuInfo", selectedInfo);
				request.getSession().setAttribute("result", "수정이 성공적으로 완료되었습니다.");
				return "/owner/updateMenuForm.jsp";
			} else {
				request.setAttribute("result", "수정에 실패했습니다. 다시 시도해주세요.");
				return "/owner/updateMenuForm.jsp";
			}
		} catch (Exception e) {
			// 업데이트 중 예외 발생 시 처리
			request.setAttribute("result", "오류 발생: " + e.getMessage());
			return "/owner/updateMenuForm.jsp";
		}
	}
}

package ex03;

import java.util.*;

public class sale {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		
		List<SaleVo> array = new ArrayList<>();
		SaleVo sale =new SaleVo(101, "냉장고", 250, 10);
		array.add(sale);
		sale =new SaleVo(102, "세탁기", 220, 5);
		array.add(sale);
		sale =new SaleVo(103, "건조기", 230, 10);
		array.add(sale);
		int last = 103;
		boolean run = true;
		
		while(run) {
			System.out.println("\n\n******재고관리******");
			System.out.println("======================================");
			System.out.println("1. 입력 2. 조회 3. 목록 4.수정 5.삭제 0. 종료");
			System.out.println("======================================");
			System.out.println("메뉴 선택 : ");
			
			String menu = sc.nextLine();
			
			switch (menu) {
			
				case "0": 
					run = false;
					System.out.println("프로그램이 종료됩니다. ");
					break;
					
				case "1":
					sale = new SaleVo();
					
					sale.setCode(last +1);
					
					System.out.println("상품코드 : " + sale.getCode());
					System.out.println("상품이름 > ");
					sale.setName(sc.nextLine());
					System.out.println("상품가격 > ");
					sale.setPrice(Integer.parseInt(sc.nextLine()));
					System.out.println("재고수량 > ");
					sale.setQnt(Integer.parseInt(sc.nextLine()));
					
					array.add(sale);
			
					
					break;
				case "2"://조회
					System.out.println("검색할 상품명을 입력해주세요: ");
					String find = sc.nextLine();
					
					boolean found = false;
					
					for(SaleVo vo: array ) {
						if(find.equals(vo.getName())) {
							System.out.println("상품이름 : "+ vo.getName());
							System.out.println("상품가격 : "+ vo.getPrice());
							System.out.println("재고수량 : "+ vo.getQnt());
							vo.setSum(vo.getPrice() * vo.getQnt());
							System.out.println("상품금액 : "+ vo.getSum());
							found = true;
						}
						
					}if(!found) {
						System.out.println("없는 이름입니다.");
					}
					
					break;
				case "3":
					for(SaleVo vo : array) {
						vo.setSum(vo.getPrice() * vo.getQnt());
						vo.print_land();
					}
					System.out.println(array.size() + "개 상품이 등록되었습니다.");
					
					break;
				case "4"://수정 
					System.out.println("수정할 코드를 입력해주세요 : ");
					
					boolean Codefound = false;
					
					String changeFromCode = sc.nextLine();
					
					for(SaleVo vo : array) {
						if(Integer.parseInt(changeFromCode) == vo.getCode()) {
							System.out.print("수정할 상품명 : " + vo.getName()+ ">");
							String newName = sc.nextLine();
							if(newName!= "") {
								vo.setName(newName);
							}
							System.out.print("수정할 가격 : " + vo.getPrice()+ ">");
							String newPrice = sc.nextLine();
							if(newPrice!= "") {
								vo.setPrice(Integer.parseInt(sc.nextLine()));
							}
							System.out.print("수정할 상품수량 : " + vo.getQnt()+ ">");
							String newQnt = sc.nextLine();
							
							if(newQnt!= "") {
								vo.setQnt(Integer.parseInt(sc.nextLine()));
							}
							
							
							System.out.println(vo.getCode() + "의 정보가 수정 되었습니다. ");
							
						}
					}
					if(!Codefound) {
						System.out.println("존재하지 않는 상품코드입니다.");
					}
				
					break;
					
				case "5"://삭제
					
					System.out.println("삭제번호 :");
					String delete = sc.nextLine();
					for(SaleVo vo : array) {
						if(Integer.parseInt(delete)==vo.getCode()) {
							array.remove(vo);
							System.out.println("삭제완료");
							break;
						}
					}
					break;
					
			}
		}
		
	}
}

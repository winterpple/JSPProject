import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.*;

public class TelecomMgntMain {

	public static void main(String[] args) {

		CallPhones callPhones = new CallPhones();
		CallCosts callCosts = new CallCosts();
		System.out.println("================================");
		System.out.println("Telecom Manage입니다. by.20122766");
		System.out.println("================================");

		while (true) {
			System.out.println(">>>>아이디를 입력하세요.");
			Scanner in = new Scanner(System.in);
			String loginId = in.nextLine();
			System.out.println(">>>>비밀번호를 입력하세요.");
			Scanner inputPwd = new Scanner(System.in);
			String password = inputPwd.nextLine();

			if ("admin".equals(loginId) && "20122766".equals(password)) {

				System.out.println(">>>>>>>>>>환영합니다<<<<<<<<<<<");
				System.out.println("=========관리자모드입니다=======");
				System.out.println("=========원하시는 메뉴를 선택해주세요=======");
				System.out.println("1. 요금제 관리"); // 요금제 등록, 요금제 수정
				System.out.println("2. 요금제 테이블"); // 등록되어있는 요금제 테이블 출력
				System.out.println("3. 기기 관리"); // 보유중인 기기 등록
				System.out.println("4. 기기 관리 현황"); // 등록 되어 있는 기기 출
				System.out.println("5. 한 달 통신비 계산 <미완>"); // 선택하는 것:
															// 기기선택/요금제타입선택/요금제종류선택
				System.out.println("6. 요금제 추천 <미완>"); // 입력값: 통화/문자/데이터
				System.out.println("7. 원배정 번호 확인 (완성 X)"); // 입력값: 핸드폰 번호 가운데
															// 네자리
				System.out.println("8. 종료");
				String menuNumber = in.next();

				if (menuNumber.equals("1")) {
					System.out.println("========1. 요금제 관리 =========");
					// 요금제는 원칙적으로 삭제하지 않습니다 (서비스가 종료되어도 사후관리를 위해 기록은 남아있어야함이
					// 원칙입니다.)
					System.out.println(">>>>>> 해당 사항이 무제한일 경우 9999로 입력해주세요.");
					System.out.println("원하시는 번호를 선택해 주세요");
					System.out.println("1. 요금제 등록");
					System.out.println("2. 요금제 수정");
					String menuNumber1 = in.next();
					if (menuNumber1.equals("1")) {
						callCosts.addCost();
					} else if (menuNumber1.equals("2")) {
						callCosts.editCost();
					} else {
						System.out.println("메뉴 중에서 선택해 주세요.");
					}

				} else if (menuNumber.equals("2")) {
					System.out.println("========2. 요금제 테이블========");
					System.out.println("요금제 테이블을 출력합니다");
					System.out.println(">>>>>> 해당 사항이 무제한일 경우 9999로 출력됩니다.");
					callCosts.printCosts();
				} else if (menuNumber.equals("3")) {
					System.out.println("========3. 기기 관리========");
					System.out.println("원하시는 번호를 선택해 주세요");
					System.out.println("1. 단말기 등록");
					System.out.println("2. 단말기 수정");
					System.out.println("3. 단말기 삭제");
					String menuNumber3 = in.next();
					if (menuNumber3.equals("1")) {
						callPhones.addPhone();
					} else if (menuNumber3.equals("2")) {
						callPhones.editPhone();
					}

					else if (menuNumber3.equals("3")) {
						callPhones.removePhone();
					}

				} else if (menuNumber.equals("4")) {
					System.out.println("========4. 기기 현황========");
					System.out.println("단말기 보유 테이블을 출력합니다");
					System.out.println("확인을 원하시는 단말기를 선택해주세요");
					callPhones.printPhones();
				}

				else if (menuNumber.equals("5")) {
					System.out.println("========5. 한 달 통신비 계산========");
					System.out.println("(모든 약정과 할부는 2년을 기준으로 계산합니다.");
					callPhones.printPhones();
					System.out.println("원하시는 단말기를 선택해주세요");
					String phone = in.next();
					System.out.println("원하시는 요금제 타입을 선택해주세요");
					String costType = in.next();
					System.out.println("원하시는 요금제를 선택해주세요");
					String cost = in.next();

				} else if (menuNumber.equals("6")) {
					System.out.println("========6. 요금제 추천========");
					System.out.println("한 달 음성 사용량을 입력해주세요 (분)");
					System.out.println("한 달 문자 사용량을 입력해주세요 (개)");
					System.out.println("한 달 데이터 사용량을 입력해주세요 (기가)");
				}

				else if (menuNumber.equals("7")) {
					System.out.println("========4. 원배정 번호 확인========");

					System.out.println("지금 사용중인 핸드폰의 가운데 번호 앞에서부터 두자리를 입력해주세요");

					System.out.println("지금 사용중인 번호의 원배정 번호 통신사는 ㅇㅇ입니다."); // 1.SKT
																			// 2.KT
																			// 3.LGU+
					System.out.println("결과 값의 통신사 내에서만 에이징(재가입)이 가능합니다!");

				} else if (menuNumber.equals("8")) {
					callPhones.savePhones();
					callCosts.saveCosts();
					System.exit(0);
				} else {
					System.out.println("메뉴 중에서 선택해 주세요.");
				}

			} else {
				System.out.println(">>>>>>>>>>>>환영합니다<<<<<<<<<<<");
				System.out.println("=========사용자모드입니다=========");
				System.out.println("=========원하시는 메뉴를 선택해주세요=======");
				System.out.println("1. 한 달 통신비 계산 <미완>");
				System.out.println("2. 요금제 추천 <미완>");
				System.out.println("3. 종료");
				String menuNumber = in.next();

				if (menuNumber.equals("1")) {
					System.out.println("========1. 한 달 통신비 계산========");
					System.out.println("(모든 약정과 할부는 2년을 기준으로 계산합니다.)");

					// System.out.println(p.phoneName 기기, costName 요금제를 사용했을 때,
					// 한달 요금은
					// (((phonePrice-(basicSupportFund+basicSupportFund*0.15))/24)+(basicCost-discount))
					Phone p = callPhones.printPhones("GalaxyS3");
					/*
					 * if(p != null){ System.out.println(p.phoneName); }
					 */

					TelecomCost c = callCosts.printCosts("올인원34");
					if (p != null) {
						System.out.println(("성공"));
					}

					/*
					 * System.out.println("원하시는 단말기를 입력해주세요"); // String
					 * phoneName = in.nextLine();
					 * System.out.println("원하시는 요금제 타입을 선택해주세요"); int
					 * costTypeNum = in.nextInt();
					 * System.out.println("원하시는 요금제를 선택해주세요"); int costNum =
					 * in.nextInt();
					 * 
					 * System.out.println("ㅇㅇ원입니다. (Tax, 단말기 할부이자 별도)"); // 사업자
					 * 회원이 // 있을 수
					 */// 있으므로,택스와
						// 할부이자는
						// 제외함
				} else if (menuNumber.equals("2")) {
					System.out.println("========6. 요금제 추천========");

					System.out.println("한 달 음성 사용량을 입력해주세요 (분)");
					System.out.println("한 달 문자 사용량을 입력해주세요 (개)");
					System.out.println("한 달 데이터 사용량을 입력해주세요 (기가)");
					System.out.println(">>>>>> 해당 사항이 무제한일 경우 9999로 출력됩니다.");

					System.out
							.println("음성 ㅇㅇ분, 문자 ㅇㅇ개, 데이터 ㅇㅇ에 맞는 추천 요금제는 ㅇㅇ타입의 ㅇㅇ요금제 입니다.");
					callCosts.printCosts();
				} else if (menuNumber.equals("3")) {
					System.exit(0);
				}

				else {
					System.out.println("메뉴 중에서 선택해 주세요.");
				}

			}

		}

	}

}

class TelecomCost {
	private String costName;// 요금제 이름
	private int basicCost;// 기본료
	private int discount;// 기본료 할인
	private String costType; // 기본 요금제 타입, 3G/LTE/맞춤형요금제
	private int call;// 음성(분)
	private int message;// 문자(개)
	private int data;// 데이터

	public TelecomCost(String costName, String costType, int basicCost,
			int discount, int call, int message, int data) {

		this.costName = costName;
		this.basicCost = basicCost;
		this.discount = discount;
		this.costType = costType;
		this.call = call;
		this.message = message;
		this.data = data;

	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public int getBasicCost() {
		return basicCost;
	}

	public void setBasicCost(int basicCost) {
		this.basicCost = basicCost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public int getCall() {
		return call;
	}

	public void setCall(int call) {
		this.call = call;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}

class Phone {
	private String phoneName;// 모델명
	private int phonePrice;// 출고가
	private int basicSupportFund;// 기본지원금 (공시지원금)

	private int addSupportFund;// 추가지원금 (Yes일 경우 공시지원금의 15%)
	private int salePrice;// 판매가 (출고가-(기본지원금+추가지원금))

	public Phone(String phoneName, int phonePrice, int basicSupportFund,
			int addSupportFund) {

		this.phoneName = phoneName;
		this.phonePrice = phonePrice;
		this.basicSupportFund = basicSupportFund;
		this.addSupportFund = addSupportFund;

	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public int getPhonePrice() {
		return phonePrice;
	}

	public void setPhonePrice(int phonePrice) {
		this.phonePrice = phonePrice;
	}

	public int getBasicSupportFund() {
		return basicSupportFund;
	}

	public void setBasicSupportFund(int basicSupportFund) {
		this.basicSupportFund = basicSupportFund;
	}

	public int getAddSupportFund() {
		return addSupportFund;
	}

	public void setAddSupportFund(int addSupportFund) {
		this.addSupportFund = addSupportFund;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

}

class CallPhones {

	Vector<Phone> phoneList;

	public CallPhones() {
		phoneList = new Vector<Phone>();
		FileReader fr = null;
		try {
			fr = new FileReader("phones.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("phones.txt 파일이 없습니다.");
		}
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		try {
			while ((line = br.readLine()) != null) {// line에 null아닌 문자열이 할당된다면
				String[] entry = line.split(":");
				Phone phone = new Phone(entry[0], Integer.parseInt(entry[1]),
						Integer.parseInt(entry[2]), Integer.parseInt(entry[3]));
				phoneList.add(phone);
			}
			fr.close();
		} catch (IOException ioe) {
			System.out.println("파일을 읽는 중에 예외가 발생했습니다.");
		}
	}

	public void addPhone() {
		Scanner in = new Scanner(System.in);
		System.out.println("모델명을 입력하세요");
		String phoneName = in.nextLine();
		System.out.println("출고가를 입력하세요.");
		int phonePrice = in.nextInt();
		System.out.println("기본지원금(공시지원금)을 입력하세요.");
		int basicSupportFund = in.nextInt();
		System.out.println("추가지원금 여부를 선택하세요. (Yes일 경우 공시지원금의 15%가 들어갑니다.)");
		System.out.println("Yes일 경우는 1, No일 경우는 2를 입력해주세요");
		int addSupportFund = in.nextInt();
		Phone phone = new Phone(phoneName, phonePrice, basicSupportFund,
				addSupportFund);
		phoneList.add(phone);
	}

	public void editPhone() {
		// 수정할 단말기를 선택합니다.
		printPhones();
		System.out.println("---------------------------");
		System.out.println("수정할 단말기 번호 입력하세요.");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		Phone phone = phoneList.get(index);
		// 수정할 파트를 선택합니다. 1.단말기 이름 2.출고가 3.기본지원금
		System.out.println("수정할 곳의 번호를 선택하세요.");
		System.out.println("1.단말기 이름 2.출고가 3.기본지원금");
		int editNum = in.nextInt();

		if (editNum == 1) {
			System.out.println("1. 단말기 이름을 입력해 주세요.");
			in.nextLine();
			String phoneName = in.nextLine();
			phone.setPhoneName(phoneName);
		} else if (editNum == 2) {
			System.out.println("2. 출고가를 입력해 주세요.");
			int phonePrice = in.nextInt();
			phone.setPhonePrice(phonePrice);
		} else if (editNum == 3) {
			System.out.println("3. 기본지원금(공시 지원금)을 입력해 주세요.");
			int basicSupportFund = in.nextInt();
			phone.setBasicSupportFund(basicSupportFund);
		} else
			System.out.println("1번~3번 중에 선택해 주세요.");
	}

	public void removePhone() {
		printPhones();
		System.out.println("---------------------------");
		System.out.println("삭제할 단말기 번호를 입력하세요.");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		phoneList.remove(index);
	}

	public void printPhones() {
		System.out.println("저장된 단말기들의 목록입니다.");
		System.out.println("추가지원금을 적용하는 경우에는 1로 표시됩니다.");
		System.out.println("추가지원금을 적용하지 않는 경우에는 2로 표시됩니다.");
		System.out.println("------------------------------------");
		for (int index = 0; index < phoneList.size(); index++) {
			Phone phone = phoneList.get(index);
			System.out.println("번호=" + index);
			System.out.println("단말기 이름=" + phone.getPhoneName());
			System.out.println("출고가=" + phone.getPhonePrice());
			System.out.println("기본 지원금(공시 지원금)=" + phone.getBasicSupportFund());
			System.out.println("추가 지원금=" + phone.getAddSupportFund());
			System.out.println("------------------------------------");
		}
	}

	public Phone printPhones(String phoneName) {
		System.out.println("저장된 단말기들의 목록입니다.");
		System.out.println("추가지원금을 적용하는 경우에는 1로 표시됩니다.");
		System.out.println("------------------------------------");
		for (Phone p : phoneList) {
			if (phoneName.equals(p.getPhoneName())) {
				return p;
			}
		}
		// for문에서 일치하는 id를 찾지못한 경우
		return null;
	}

	public void savePhones() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("phones.txt");
		} catch (IOException ioe) {
			System.out.println("phones.txt 파일을 쓰기모드로 여는 데 실패했습니다.");
		}
		PrintWriter pw = new PrintWriter(fw);
		for (int index = 0; index < phoneList.size(); index++) {
			Phone phone = phoneList.get(index);
			String str = phone.getPhoneName() + ":" + phone.getPhonePrice()
					+ ":" + phone.getBasicSupportFund() + ":"
					+ phone.getAddSupportFund();
			pw.println(str);
		}
		pw.flush();
		pw.close();
	}

}

class CallCosts {

	Vector<TelecomCost> costList;

	public CallCosts() {
		costList = new Vector<TelecomCost>();
		FileReader fr = null;
		try {
			fr = new FileReader("costs.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println("costs.txt 파일이 없습니다.");
		}
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		try {
			while ((line = br.readLine()) != null) {// line에 null아닌 문자열이 할당된다면
				String[] entry = line.split(":");
				TelecomCost cost = new TelecomCost(entry[0], entry[1],
						Integer.parseInt(entry[2]), Integer.parseInt(entry[3]),
						Integer.parseInt(entry[4]), Integer.parseInt(entry[5]),
						Integer.parseInt(entry[6]));
				costList.add(cost);
			}
			fr.close();
		} catch (IOException ioe) {
			System.out.println("파일을 읽는 중에 예외가 발생했습니다.");
		}
	}

	public void addCost() {
		Scanner in = new Scanner(System.in);
		System.out.println("요금제 타입을 입력하세요");
		String costType = in.nextLine();
		System.out.println("요금제 이름을 입력하세요.");
		String costName = in.nextLine();
		System.out.println("기본료를 입력하세요");
		int basicCost = in.nextInt();
		System.out.println("기본료 할인을 입력하세요");
		int discount = in.nextInt();
		System.out.println("제공되는 통화(분)을 입력하세요");
		int call = in.nextInt();
		System.out.println("제공되는 문자(개)을 입력하세요");
		int message = in.nextInt();
		System.out.println("제공되는 데이터(MB/GB)를 입력하세요");
		int data = in.nextInt();
		TelecomCost cost = new TelecomCost(costType, costName, basicCost,
				discount, call, message, data);
		costList.add(cost);
	}

	public void editCost() {
		// 수정할 단말기를 선택합니다.
		printCosts();
		System.out.println("---------------------------");
		System.out.println("수정할 요금제의 번호 입력하세요.");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		TelecomCost cost = costList.get(index);
		// 수정할 파트를 선택합니다. 1.단말기 이름 2.출고가 3.기본지원금
		System.out.println("수정할 곳의 번호를 선택하세요.");
		System.out.println("1.요금제 타입 2.요금제 이름 3.기본료 4.기본료 할인 5.통화 6.문자 7.데이터");
		int editNum = in.nextInt();
		if (editNum == 1) {
			System.out.println("1. 요금제 타입을 입력해 주세요.");
			in.nextLine();
			String costType = in.nextLine();
			cost.setCostType(costType);
		} else if (editNum == 2) {
			System.out.println("2. 요금제 이름을 입력해 주세요.");
			in.nextLine();
			String costName = in.nextLine();
			cost.setCostName(costName);
		} else if (editNum == 3) {
			System.out.println("3. 기본료를 입력해 주세요.");
			int basicCost = in.nextInt();
			cost.setBasicCost(basicCost);
		} else if (editNum == 4) {
			System.out.println("4. 기본료 할인을 입력해 주세요.");
			int discount = in.nextInt();
			cost.setDiscount(discount);
		}

		else if (editNum == 5) {
			System.out.println("5. 제공되는 통화(분)을 입력하세요");
			int call = in.nextInt();
			cost.setCall(call);
		} else if (editNum == 6) {
			System.out.println("6. 제공되는 문자(개)을 입력하세요");
			int message = in.nextInt();
			cost.setMessage(message);
		} else if (editNum == 7) {
			System.out.println("7. 제공되는 데이터(MB/GB)를 입력하세요");
			int data = in.nextInt();
			cost.setData(data);
		} else
			System.out.println("1번~7번 중에 선택해 주세요.");
	}

	public void printCosts() {
		System.out.println("요금제 테이블을 출력합니다.");
		System.out.println("------------------------------------");
		for (int index = 0; index < costList.size(); index++) {
			TelecomCost cost = costList.get(index);
			System.out.println("번호=" + index);
			System.out.println("요금제 타입=" + cost.getCostType());
			System.out.println("요금제 이름=" + cost.getCostName());
			System.out.println("요금제 기본료=" + cost.getBasicCost());
			System.out.println("요금제 기본료 할인=" + cost.getDiscount());
			System.out.println("전화 (분) =" + cost.getCall());
			System.out.println("문자 (개) =" + cost.getMessage());
			System.out.println("데이터(MB/GB)=" + cost.getData());
			System.out.println("------------------------------------");
		}
	}

	public TelecomCost printCosts(String costName) {
		System.out.println("저장된 단말기들의 목록입니다.");
		System.out.println("추가지원금을 적용하는 경우에는 1로 표시됩니다.");
		System.out.println("------------------------------------");
		for (TelecomCost c : costList) {
			if (costName.equals(c.getCostName())) {
				return c;
			}
		}
		// for문에서 일치하는 id를 찾지못한 경우
		return null;
	}

	public void saveCosts() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("costs.txt");
		} catch (IOException ioe) {
			System.out.println("costs.txt 파일을 쓰기모드로 여는 데 실패했습니다.");
		}
		PrintWriter pw = new PrintWriter(fw);
		for (int index = 0; index < costList.size(); index++) {
			TelecomCost cost = costList.get(index);
			String str = cost.getCostType() + ":" + cost.getCostName() + ":"
					+ cost.getBasicCost() + ":" + cost.getDiscount() + ":"
					+ cost.getCall() + ":" + cost.getMessage() + ":"
					+ cost.getData();
			pw.println(str);
		}
		pw.flush();
		pw.close();
	}

}

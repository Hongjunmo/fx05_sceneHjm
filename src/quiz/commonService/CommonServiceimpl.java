package quiz.commonService;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import quiz.Member;

public class CommonServiceimpl implements ICommonService {

	private Parent root;
	Member mb = new Member();

	@Override
	public void serRoot(Parent root) {
		this.root = root;
	}

	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>) root.lookup("#cmbAge");
		cmbAge.getItems().addAll("20대 미만", "20대", "30대", "40대 이상");
	}

	@Override
	public void memberCancle() {
		Stage stage = (Stage) root.getScene().getWindow();

		stage.close();
	}

	public void SingUp() {
		String age = getComboBox();
		getName();
		getId();
		getPw();
		chkPw();
		chkhobby();
		chkgen();
		System.out.println("나이 : " + age);
	}

	public void chkgen() {
		if (getGender() == true) {
			System.out.println("성별 : 남성");
		} else {
			System.out.println("성별 : 여성");
		}

	}

	public void chkhobby() {

		int hobby = getHobby();
		if (hobby == 1) {
			System.out.println("취미 : 음악");
		} else if (hobby == 2) {
			System.out.println("취미 : 운동");
		} else if (hobby == 3) {
			System.out.println("취미 : 음악,운동");
		} else if (hobby == 4) {
			System.out.println("취미 : 영화");
		} else if (hobby == 5) {
			System.out.println("취미 : 음악,영화");
		} else if (hobby == 6) {
			System.out.println("취미 : 운동,영화");
		} else if (hobby == 7) {
			System.out.println("취미 : 음악,운동,영화");
		}
	}

	public boolean getGender() {
		RadioButton rdoMan = (RadioButton) root.lookup("#rdoMan");
		if (rdoMan.isSelected()) {
			return true;
		} else
			return false;
	}

	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>) root.lookup("#cmbAge");
		String age = null;
		if (cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해 주셈");
		} else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}

	public int getHobby() {
		int hobby = 0;
		CheckBox music = (CheckBox) root.lookup("#chkMusic");
		CheckBox sport = (CheckBox) root.lookup("#chkSport");
		CheckBox movie = (CheckBox) root.lookup("#chkMovie");
		if (music.isSelected()) {
			hobby += 1;
		}
		if (sport.isSelected()) {
			hobby += 2;
		}
		if (movie.isSelected()) {
			hobby += 4;
		}
		return hobby;
	}

	public void getName() {
		TextField tf = (TextField) root.lookup("#fxName");
		mb.setName(tf.getText());
		System.out.println("이름 :" + mb.getName());
	}

	public void getId() {
		TextField tf = (TextField) root.lookup("#fxId");
		mb.setId(tf.getText());
		System.out.println("아이디 :" + mb.getId());
	}

	public void getPw() {
		TextField tf = (TextField) root.lookup("#fxPw");
		mb.setPw(tf.getText());
		System.out.println("비밀번호 :" + mb.getPw());
	}

	public void chkPw() {
		TextField tf1 = (TextField) root.lookup("#fxPw");
		TextField tf = (TextField) root.lookup("#fxPwChk");
		String pw = tf1.getText();
		if (pw.trim().equals(tf.getText().trim())) {
			System.out.print("PW 일치 확인 : ");
			System.out.println("비밀번호가 일치합니다!");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("비밀번호 확인");
			alert.setTitle("비밀번호 확인");
			alert.setContentText("비밀번호가 일치하지 않습니다.");
			alert.show();
			tf.clear();
			tf.requestFocus();
		}
	}
}

package quiz;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quiz.commonService.CommonServiceimpl;

public class Controller implements Initializable {

	private Parent root;

	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void login() {
		System.out.println("123");
	}

	public void sign() {
		try {
			Stage arg0 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			CommonServiceimpl ctl = loader.getController();
			ctl.serRoot(root);

			arg0.setScene(scene);
			arg0.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancle() {
		CommonServiceimpl cs = new CommonServiceimpl();
		cs.serRoot(root);
		cs.memberCancle();

	}
}

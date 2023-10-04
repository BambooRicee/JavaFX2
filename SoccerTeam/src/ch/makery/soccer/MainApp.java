package ch.makery.soccer;
import java.io.IOException;
import ch.makery.soccer.model.Person;
import ch.makery.soccer.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    /**
     * ������, � ���� ������������ ������ ���������.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    /**
     * �����������
     */
    public MainApp() {
        // � �������� ������� ��������� ��������� ������
        personData.add(new Person("���������", "�������"));
        personData.add(new Person("������", "�������"));
        personData.add(new Person("�����", "�������"));
        personData.add(new Person("������", "������"));
        personData.add(new Person("�����", "�����"));
        personData.add(new Person("���������", "�����"));
        personData.add(new Person("����", "-"));
        personData.add(new Person("�������", "��������"));
        personData.add(new Person("������", "������"));
        personData.add(new Person("������", "������"));
        personData.add(new Person("�����", " ����"));
        personData.add(new Person("������", "�������"));
        personData.add(new Person("������", "�������"));
        personData.add(new Person("����", "����"));
        personData.add(new Person("�������", "�����"));
        personData.add(new Person("����", "������"));
        personData.add(new Person("����", "��������"));
        personData.add(new Person("���������", "��������"));
        personData.add(new Person("������", "�������"));
        personData.add(new Person("����", "�������"));
        personData.add(new Person("��������", "��������"));
        personData.add(new Person("�����", "������"));
        personData.add(new Person("���������", "��������"));
    }
    /**
     * ���������� ������ � ���� ������������ ������ ���������.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("���������� ����");

        initRootLayout();

        showPersonOverview();
    }
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            // ��� ����������� ������ � �������� ����������.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
}
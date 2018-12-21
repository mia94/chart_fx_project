package chart_project.chart_panel;

import chart_project.dto.Student;
import chart_project.main.InitScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;

@SuppressWarnings("serial")
public class PanelBarChart extends JFXPanel implements InitScene {
	//슈퍼생성
	public PanelBarChart() {
	}
	//바차트 배열 선언
	private BarChart<String, Number> barChart;
	
	@Override
	public Scene createScene() {
		Group root = new Group();//javafx.scene.Group - import
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);//"자동 크기 조정"하여 상태가 변경 될 때 영역과 컨트롤의 크기가 올바르게 조정
		
		//막대형 차트의 X축과 Y축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("과목");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("점수");
		
		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Bar Chart");
		
		barChart.setPrefSize(500, 250);
		barChart.setData(getChartData());
		return null;
	}
	

	private ObservableList<Series<String, Number>> getChartData() {
		ObservableList<XYChart<String, Number>> list = FXCollections.observableArrayList();
		Student std = new Student("S001", "김보민", 100, 80, 90);
		Student std2 = new Student("S002", "박수완", 90, 100, 80);
		
		list.add(getChartData(std));
		list.add(getChartData(std2));
		
		return null;
	}

	private XYChart<String, Number> getChartData(Student std) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		
		dataSeries.setName(std.getStdName());
		dataSeries.getData().add(new XYChart.Data<>("국어",std.getKorScore()));
		dataSeries.getData().add(new XYChart.Data<>("영어",std.getEngScore()));
//		dataSeries.getData().add(new XYChart.Data<>("수학"),std.getE)
		
		return null;
	}

	

}

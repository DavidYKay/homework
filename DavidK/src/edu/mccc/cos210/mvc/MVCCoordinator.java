package edu.mccc.cos210.mvc;
import com.cbthinkx.util.Debug;
public class MVCCoordinator {
	private MVCModel model;
	private MVCView1 view1;
	private MVCView2 view2;
	private MVCController controller;
	public MVCCoordinator() {
		Debug.println("MVCoordinator()");
		this.model = new MVCModel();
		this.view1 = new MVCView1(this.model);
		this.view2 = new MVCView2(this.model);
		this.model.addMVCModelListener(this.view1);
		this.model.addMVCModelListener(this.view2);
		this.controller = new MVCController(this.model);
	}
	public MVCView1 getView1() {
		Debug.println("MVCoordinator.getView1()");
		return this.view1;
	}
	public MVCView2 getView2() {
		Debug.println("MVCoordinator.getView2()");
		return this.view2;
	}
}

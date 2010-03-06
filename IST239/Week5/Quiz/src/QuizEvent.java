import java.util.EventObject;
public class QuizEvent extends EventObject {                                                      
	public QuizEvent(QuizModel model) {                                                            
		super(model);
	}
}


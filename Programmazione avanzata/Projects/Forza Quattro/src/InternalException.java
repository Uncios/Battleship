import java.io.IOException;

public class InternalException extends RuntimeException {

	public InternalException(Throwable e) {
		super(e);
	}

	private static final long serialVersionUID = 1L;

}

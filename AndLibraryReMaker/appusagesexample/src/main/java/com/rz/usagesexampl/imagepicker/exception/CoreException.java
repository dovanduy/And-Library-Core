package com.rz.usagesexampl.imagepicker.exception;

public class CoreException extends Exception {
    private String errorMessage = null;

    public CoreException() {
        super();
    }

    public CoreException(CoreError.Reason errorReason) {
        super(errorReason.getErrorDescription());
        errorMessage = errorReason.getErrorDescription();
    }

    public CoreException(Throwable argCause) {
        super(argCause);
    }

    public CoreException(CoreError.Reason errorReason, Throwable argCause) {
        super(errorReason.getErrorDescription(), argCause);
        errorMessage = errorReason.getErrorDescription();
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}

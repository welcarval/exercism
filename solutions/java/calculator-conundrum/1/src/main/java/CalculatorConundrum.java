class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        int result = switch (operation) {
            case "+" -> operand1 + operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                try {
                    yield operand1 / operand2;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
            }
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        };

        return String.format("%d %s %d = %d", operand1, operation, operand2, result);
    }
}

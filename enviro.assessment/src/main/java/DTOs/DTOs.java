public record InvestorDTO(Long id,
    String name,
    int age, 
    String email, 
    List<Product> products, 
    double totalBalance) {}

public record WithdrawRequestDTO(
    @NotNull Long investorId,
    @NotBlank Sting productType,
    @Min(value=1, message=" Amount must be above 0") double amount
) {}
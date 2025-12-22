@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;

    public RiskThresholdController(RiskThresholdService riskThresholdService) {
        this.riskThresholdService = riskThresholdService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> analyzeRisk(
            @PathVariable Long id,
            @RequestBody RiskThresholdRequest request) {

        return ResponseEntity.ok(
                riskThresholdService.evaluateRisk(request)
        );
    }
}

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByTicker(String ticker);
    List<Stock> findBySector(String sector);
}

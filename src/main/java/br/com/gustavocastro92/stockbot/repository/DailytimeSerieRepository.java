package br.com.gustavocastro92.stockbot.repository;

import br.com.gustavocastro92.stockbot.model.db.DailyTimeSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailytimeSerieRepository extends JpaRepository<DailyTimeSerie, Integer> {
}

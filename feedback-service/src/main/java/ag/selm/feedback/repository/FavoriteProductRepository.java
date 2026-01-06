package ag.selm.feedback.repository;

import ag.selm.feedback.entity.FavouriteProduct;
import ag.selm.feedback.entity.ProductReview;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FavoriteProductRepository extends ReactiveCrudRepository<FavouriteProduct, UUID> {



    Flux<FavouriteProduct> findAllByUserId(String userId);

    Mono<Void> deleteByProductIdAndUserId(int productId, String userId);

    Mono<FavouriteProduct> findByProductIdAndUserId(int productId, String userId);
}





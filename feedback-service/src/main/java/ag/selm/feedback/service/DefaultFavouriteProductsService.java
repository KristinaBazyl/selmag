package ag.selm.feedback.service;

import ag.selm.feedback.entity.FavouriteProduct;
import ag.selm.feedback.repository.FavoriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultFavouriteProductsService implements FavouriteProductsService {

    private  final FavoriteProductRepository favoriteProductRepository;

    @Override
    public Mono<FavouriteProduct> addProductToFavourites(int productId, String userId) {
        return this.favoriteProductRepository.save(new FavouriteProduct(UUID.randomUUID(), productId, userId));
    }

    @Override
    public Mono<Void> removeProductFromFavourites(int productId, String userId) {
        return this.favoriteProductRepository.deleteByProductIdAndUserId(productId, userId);
    }

    @Override
    public Mono<FavouriteProduct> findFavouriteProductByProduct(int productId, String userId) {
        return this.favoriteProductRepository.findByProductIdAndUserId(productId, userId);
    }

    @Override
    public Flux<FavouriteProduct> findFavouriteProducts(String userId) {
        return this.favoriteProductRepository.findAllByUserId(userId);
    }
}

package ag.selm.customer.service;

import ag.selm.customer.entity.FavouriteProduct;
import ag.selm.customer.repository.FavoriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultFavoriteProductsService implements FavoriteProductsService{

    private  final FavoriteProductRepository favoriteProductRepository;

    @Override
    public Mono<FavouriteProduct> addProductToFavourites(int productId) {
        return this.favoriteProductRepository.save(new FavouriteProduct(UUID.randomUUID(), productId));
    }

    @Override
    public Mono<Void> removeProductFromFavourites(int productId) {
        return this.favoriteProductRepository.deleteByProductId(productId);
    }

    @Override
    public Mono<FavouriteProduct> findFavouriteProductByProduct(int productId) {
        return this.favoriteProductRepository.findByProductId(productId);
    }

    @Override
    public Flux<FavouriteProduct> findFavouriteProducts() {
        return this.favoriteProductRepository.findAll();
    }
}

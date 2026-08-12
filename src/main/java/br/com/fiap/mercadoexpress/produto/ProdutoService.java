package br.com.fiap.mercadoexpress.produto;

import br.com.fiap.mercadoexpress.common.ResourceNotFoundException;
import br.com.fiap.mercadoexpress.produto.dto.ProdutoPatchRequest;
import br.com.fiap.mercadoexpress.produto.dto.ProdutoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto create(ProdutoRequest request) {
        Produto produto = Produto.builder()
                .nome(request.nome())
                .tipo(request.tipo())
                .setor(request.setor())
                .tamanho(request.tamanho())
                .preco(request.preco())
                .build();
        return repository.save(produto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id " + id));
    }

    public Produto update(Long id, ProdutoRequest request) {
        Produto produto = findById(id);
        produto.setNome(request.nome());
        produto.setTipo(request.tipo());
        produto.setSetor(request.setor());
        produto.setTamanho(request.tamanho());
        produto.setPreco(request.preco());
        return repository.save(produto);
    }

    public Produto patch(Long id, ProdutoPatchRequest request) {
        Produto produto = findById(id);
        if (request.nome() != null) {
            produto.setNome(request.nome());
        }
        if (request.tipo() != null) {
            produto.setTipo(request.tipo());
        }
        if (request.setor() != null) {
            produto.setSetor(request.setor());
        }
        if (request.tamanho() != null) {
            produto.setTamanho(request.tamanho());
        }
        if (request.preco() != null) {
            produto.setPreco(request.preco());
        }
        return repository.save(produto);
    }

    public void delete(Long id) {
        Produto produto = findById(id);
        repository.delete(produto);
    }
}

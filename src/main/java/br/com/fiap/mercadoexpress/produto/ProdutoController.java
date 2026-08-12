package br.com.fiap.mercadoexpress.produto;

import br.com.fiap.mercadoexpress.produto.dto.ProdutoPatchRequest;
import br.com.fiap.mercadoexpress.produto.dto.ProdutoRequest;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mercado")
public class ProdutoController {

    private final ProdutoService service;
    private final ProdutoModelAssembler assembler;

    public ProdutoController(ProdutoService service, ProdutoModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping
    public ResponseEntity<EntityModel<?>> criar(@Valid @RequestBody ProdutoRequest request) {
        Produto produto = service.create(request);
        EntityModel<?> model = assembler.toModel(produto);
        return ResponseEntity
                .created(model.getRequiredLink("self").toUri())
                .body(model);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<?>>> listar() {
        List<EntityModel<?>> produtos = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<?>> collectionModel = CollectionModel.of(produtos,
                linkTo(methodOn(ProdutoController.class).listar()).withSelfRel());

        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<?>> buscarPorId(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return ResponseEntity.ok(assembler.toModel(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<?>> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequest request) {
        Produto produto = service.update(id, request);
        return ResponseEntity.ok(assembler.toModel(produto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<?>> atualizarParcial(@PathVariable Long id, @RequestBody ProdutoPatchRequest request) {
        Produto produto = service.patch(id, request);
        return ResponseEntity.ok(assembler.toModel(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

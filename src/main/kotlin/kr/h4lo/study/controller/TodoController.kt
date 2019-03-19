package kr.h4lo.study.controller

import kr.h4lo.study.model.Todo
import kr.h4lo.study.repository.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController (val todoRepository: TodoRepository) {
    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.GET])
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo> {
        return todoRepository.findById(todoId)
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        todoRepository.save(todo)
        return todo
    }

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("todoId") todoId: Long) {
        var target: Todo = todoRepository.findById(todoId).get()
        target.title = todo.title
        target.description = todo.description
        target.finished = todo.finished

        todoRepository.save(target)
    }

    @RequestMapping(path = ["/{todoId}"], method = [RequestMethod.DELETE])
    fun deleteTodo(@PathVariable("todoId") todoId: Long) {
        todoRepository.deleteById(todoId)

    }
}
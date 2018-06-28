package info.matsumana.demo.service

import info.matsumana.demo.entity.Todo
import info.matsumana.demo.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TodoService(val repository: TodoRepository) {

    @Transactional(readOnly = false)
    fun insert(todo: Todo) {
        repository.insert(todo)
    }

    fun selectFromSlave(): Todo {
        return repository.select()
    }

    // TODO SQL error occurs when executed on master
    @Transactional(readOnly = false)
    fun selectFromMaster(): Todo {
        return repository.select()
    }
}

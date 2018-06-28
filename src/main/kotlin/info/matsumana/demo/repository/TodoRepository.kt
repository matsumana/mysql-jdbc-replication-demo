package info.matsumana.demo.repository

import info.matsumana.demo.entity.Todo
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface TodoRepository {

    @Insert("""
    INSERT INTO `todo`
    (
      `title`
    , `detail`
    , `finished`
    )
    VALUES
    (
      #{title}
    , #{detail}
    , #{finished}
    )
    """)
    @Options(useGeneratedKeys = true)
    fun insert(todo: Todo)

    // Ambiguous Groups
    @Select("""
    SELECT MAX(`id`)
         , `title`
         , `detail`
         , `finished`
      FROM `todo`
    """)
    fun select(): Todo
}

package cz.kamenitxan.templateapp.pagelet

import cz.kamenitxan.jakon.core.database.DBHelper
import cz.kamenitxan.jakon.core.dynamic.{AbstractJsonPagelet, Get, JsonPagelet}
import cz.kamenitxan.jakon.core.dynamic.entity.{AbstractJsonResponse, ResponseStatus}
import cz.kamenitxan.templateapp.controler.ButtonsController
import cz.kamenitxan.templateapp.entity.Button

@JsonPagelet(path = "/api")
class BUttonPagelet extends AbstractJsonPagelet {

	@Get("/buttons")
	def getButtons(): AbstractJsonResponse[Seq[Button]] = {

		//new AbstractJsonResponse[Seq[Button]](status = ResponseStatus.success, ) {}

		DBHelper.withDbConnection(implicit conn => {
			val stmt = conn.createStatement()
			implicit val cls: Class[Button] = classOf[Button]
			val words = DBHelper.selectDeep(stmt, ButtonsController.ALL_WORDS_SQL)

			new AbstractJsonResponse[Seq[Button]](status = ResponseStatus.success, words) {}

		})

	}

}

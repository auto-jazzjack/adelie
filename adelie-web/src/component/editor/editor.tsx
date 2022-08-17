import React from "react";
import {Pair, Schema} from "../common/model";
/*import {Parser} from "../common/parser";
import {getSchema} from "../../apis/schema";
import {fetcher, initStatus} from "../../apis/apicaller";
import {ApiStatus} from "../../apis/type";*/
import {Form, TextArea} from "semantic-ui-react";
import {TextAreaProps} from "semantic-ui-react/dist/commonjs/addons/TextArea/TextArea";
import {findContext} from "../common/parser";
import {AutoSuggest} from "../common/autosuggest";

type EditorProps = {
    schemaURL: string
}

//let schema = {} as Schema | null
let mockSchema = {} as Schema | null

export function init0() {

    mockSchema = {
        currentField: new Set<String>(["aa", "bb", "cc", "dd"]),
        nextField: new Map<String, Schema>([
                ["first", {
                    currentField: new Set<String>(["ff", "ffg", "qwe", "zxc"]),
                } as Schema],
                ["second", {
                    currentField: new Set<String>(["2ff", "22ffg", "2qwe", "2zxc"]),
                } as Schema],
            ]
        )
    } as Schema
}

export const Editor = ({schemaURL}: EditorProps) => {

    init0()

    const [suggests, setSuggests] = React.useState<Pair<number, String[]>>({
        key: 0,
        value: [] as String[]
    });
    const [content, setContent] = React.useState<String>("");
    const [position, setPosition] = React.useState<number>(0);

    /* Renderer */
    /*const [_, setSchemaURL] = React.useState<ApiStatus<string>>(initStatus);

    React.useEffect(() => {
        fetcher(getSchema(), setSchemaURL)
        schema = Parser(schemaURL)
        console.log(schema)
    })
    */


    return (

        <div className="Editor">
            <Form>
                <TextArea placeholder='Body' style={{minHeight: 200, maxHeight: 200}}/>
                <AutoSuggest indent={suggests.key} names={suggests.value} consumer={(data) => {
                    console.log(data)
                    let prefix = content.substring(0, position) + "\n" + repeatedTab(data.value) + data.key
                    setContent(prefix + content.substring(position + 1, content.length))
                    setPosition(prefix.length)
                }}/>
                <TextArea
                    value={content as string}
                    onChange={(event, data) => {
                        setPosition(event.target.selectionEnd)

                        let suggested = suggest(position, data);
                        setSuggests(suggested)
                        setContent(data.value as string)
                    }}
                    placeholder='Query'
                    style={{minHeight: 200, maxHeight: 200}}
                />
            </Form>
        </div>
    )
}

function repeatedTab(size: number): string {
    let retv = ""
    for (let i = 0; i < size; i++) {
        retv += "\t"
    }
    return retv
}

function suggest(position: number, data: TextAreaProps): Pair<number, String[]> {
    let v = data.value as string
    let contexts = findContext(v, position);

    let pos = mockSchema
    let indent = 0
    for (let i = 0; i < contexts.length; i++) {
        if (pos?.nextField.has(contexts[i])) {
            pos = pos.nextField.get(contexts[i]) ?? null
            indent++
        }
    }

    let temp = new Set<String>()

    if (pos?.nextField !== undefined) {
        pos?.nextField.forEach((v, k) => {
            temp.add(k)
        })
    }
    if (pos?.currentField !== undefined) {
        pos?.currentField.forEach((v) => {
            temp.add(v)
        })
    }

    let retv = [] as String[]
    temp.forEach(i => {
        retv.push(i)
    })

    return {
        key: indent,
        value: retv
    } as Pair<number, String[]>
}
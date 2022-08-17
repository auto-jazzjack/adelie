import React from "react";
import {Dropdown, DropdownItemProps} from "semantic-ui-react";
import {DropdownProps} from "semantic-ui-react/dist/commonjs/modules/Dropdown/Dropdown";
import {Pair} from "./model";

export type SuggestProps = {
    names: String[]
    indent: number
    consumer: (data: Pair<String/*Key*/, number/*number of indent*/>) => void
}

export const AutoSuggest = ({names, indent, consumer}: SuggestProps) => {

    return (<div>
        <Dropdown
            search
            searchInput={{autoFocus: true}}
            selection
            options={names.map((entity) => ({
                key: entity as string,
                value: entity as string,
                content: entity
            } as DropdownItemProps))}
            onChange={(event: React.SyntheticEvent<HTMLElement>, data: DropdownProps) => {

                consumer.call(this, {
                    key: data.value as string,
                    value: indent
                })

            }}>
        </Dropdown>
    </div>)
}

